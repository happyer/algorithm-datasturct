package patten.adapter;

/**
 * Created by chauncy on 2018/7/26.
 */
public class PrintAdapter extends HelloPrint implements Print {


    @Override
    public void printWeakHello() {
        printHello();
    }

    @Override
    public void printWeakStrange() {
        printStrange();
    }
}
