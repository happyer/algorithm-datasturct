package patten.adapter;

import java.io.*;
import java.util.Properties;

/**
 * Created by chauncy on 2018/7/26.
 */
public class FileProperties extends Properties implements FileIO {


    @Override
    public void readFromFile(String fileName) throws IOException {
        try {
            InputStream inputStream = new FileInputStream(new File(fileName));
            load(inputStream);
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        OutputStream outputStream = new FileOutputStream(new File(fileName));
        store(outputStream, "this-comment");
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return getProperty(key);
    }
}
