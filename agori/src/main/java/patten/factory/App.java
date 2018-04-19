package patten.factory;

import patten.factory.card.FactoryImpl;
import patten.factory.framework.Factory;
import patten.factory.framework.Product;

/**
 * Created by chauncy on 2018/7/26.
 */
public class App {

    public static void main(String[] args) {
        Factory factory = new FactoryImpl();
       Product product1 =  factory.create("one");
       Product product2 =  factory.create("two");

       product1.use();
       product2.use();

    }
}
