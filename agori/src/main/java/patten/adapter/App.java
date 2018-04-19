package patten.adapter;

/**
 * Created by chauncy on 2018/7/26.
 */
public class App {


    /**
     * adapter 提高了类的复用性,在不用更改原来的类的情况下面,适配其他的功能(新的接口)
     * @param args
     */
    public static void main(String[] args) {

        Print print = new PrintAdapter();
        print.printWeakHello();
        print.printWeakStrange();

    }
}
