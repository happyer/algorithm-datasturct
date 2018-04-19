package com.chauncy.mvcframework.servlet;

import com.chauncy.mvcframework.anotation.MyAutowired;
import com.chauncy.mvcframework.anotation.MyController;
import com.chauncy.mvcframework.anotation.MyRequestMapping;
import com.chauncy.mvcframework.anotation.MyService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * Created by chauncy on 2019/3/26.
 */
public class MyDispatchServlet extends HttpServlet {


    private static final long serialVersionUID = 1773482689711293410L;

    //web.xml configLocation
    private static final String location = "contextConfigLocation";


    //save properties
    private Properties properties = new Properties();

    //all annotation class name
    private List<String> classNames = new ArrayList<>();


    //ioc collection,spring is concurrent hash map
    private Map<String, Object> ioc = new HashMap<>();


    //url maping method
    private Map<String, Method> handlerMapping = new HashMap<>();


    @Override
    public void init(ServletConfig config) throws ServletException {

        //init config
        initConfig(config.getInitParameter(location));

        //scan class
        scanClass(properties.getProperty("scanPackage"));

        //instance class save to ioc
        instance();

        //DI
        autowired();

        //init url handler mapping

        initHandlerMapping();

        System.out.println("framework init");
    }

    private void initHandlerMapping() {
        if (ioc.isEmpty()) return;
        for (Map.Entry<String, Object> stringObjectEntry : ioc.entrySet()) {
            Class<?> clazz = stringObjectEntry.getValue().getClass();
            if (!clazz.isAnnotationPresent(MyController.class)) continue;
            String baseUrl = "";
            if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                MyRequestMapping requestMapping = clazz.getAnnotation(MyRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(MyRequestMapping.class)) continue;
                MyRequestMapping myRequestMapping = method.getAnnotation(MyRequestMapping.class);
                String url = baseUrl + myRequestMapping.value().replaceAll("/+", "/");
                handlerMapping.put(url, method);
                System.out.println("mapped:" + url + "," + method);
            }
        }

    }

    private void autowired() {
        if (ioc.isEmpty()) return;
        for (Map.Entry<String, Object> stringObjectEntry : ioc.entrySet()) {
            //get all properties of instance
            Field[] fields = stringObjectEntry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(MyAutowired.class)) continue;
                MyAutowired autowired = field.getAnnotation(MyAutowired.class);
                String beanName = autowired.value().trim();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    field.set(stringObjectEntry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * instance
     */
    private void instance() {
        if (classNames.isEmpty() || classNames.size() == 0) return;
        for (String className : classNames) {
            try {
                Class<?> cls = Class.forName(className);
                if (cls.isAnnotationPresent(MyController.class)) {
                    String beanName = lower(cls.getSimpleName());
                    ioc.put(beanName, cls.newInstance());

                } else if (cls.isAnnotationPresent(MyService.class)) {
                    MyService service = cls.getAnnotation(MyService.class);
                    String beanName = service.value();
                    if (!"".equals(beanName.trim())) {
                        ioc.put(beanName, cls.newInstance());
                        continue;
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    for (Class<?> anInterface : interfaces) {
                        ioc.put(anInterface.getName(), cls.newInstance());
                    }
                } else {
                    continue;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private String lower(String string) {
        char[] chars = string.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * take class name into className list
     *
     * @param scanPackage
     */
    private void scanClass(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                scanClass(scanPackage + "." + file.getName());
            } else {
                classNames.add(scanPackage + "." + file.getName().replaceAll(".class", "").trim());
            }
        }

    }

    /**
     * load resource into properties
     *
     * @param initParameter
     */
    private void initConfig(String initParameter) {
        InputStream inputStream = null;
        inputStream = this.getClass().getClassLoader().getResourceAsStream(initParameter);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        disPatch(req, resp);
    }

    private void disPatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String contextPath = req.getContextPath();
        String url = req.getRequestURI().replace(contextPath, "").replaceAll("/+", "/");
        if (!handlerMapping.containsKey(url)) {
            resp.getWriter().write("404");
        }
        Map<String, String[]> parameterMap = req.getParameterMap();
        Method method = handlerMapping.get(url);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] paramVal = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class parameterType = parameterTypes[i];
            if (parameterType == HttpServletRequest.class) {
                paramVal[i] = req;
                continue;
            }else if (parameterType == HttpServletResponse.class){
                paramVal[i] = resp;
                continue;
            }else if (parameterType == String.class){
                for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
                   String val=  Arrays.toString(stringEntry.getValue()).replaceAll("\\[|\\]","")
                            .replaceAll(",\\s","");
                   paramVal[i] = val;
                }
            }
        }
        String beanName = lower(method.getDeclaringClass().getSimpleName());
        try {
            method.invoke(ioc.get(beanName),paramVal);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        disPatch(req, resp);
    }
}
