package patten.factory.card;

import patten.factory.framework.Product;

import static java.lang.System.out;

/**
 * Created by chauncy on 2018/7/26.
 */
public class ConcreteProduct extends Product {


    private String owner;

    public ConcreteProduct(String owner) {
        this.owner = owner;
    }

    @Override
    public void use() {
        out.println("use.." + owner);
    }


}
