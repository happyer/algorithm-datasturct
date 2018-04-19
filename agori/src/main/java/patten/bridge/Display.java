package patten.bridge;

/**
 * Created by chauncy on 2018/7/26.
 */
public  class Display {
    private DisplayImpl displayImpl;


    public Display(DisplayImpl displayImpl) {
        this.displayImpl = displayImpl;
    }

    public void method1(){
        displayImpl.method01Impl();
    }
    public void method2(){
        displayImpl.method02Impl();

    }
}
