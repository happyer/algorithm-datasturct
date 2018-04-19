package patten.prototype.message;

import patten.prototype.framework.Product;

import static java.lang.System.out;

/**
 * Created by chauncy on 2018/7/26.
 */
public class Message implements Product {

    @Override
    public void use() {
        out.println("message use");
    }

    @Override
    public Product cloneProduct() throws CloneNotSupportedException {
        return (Product) clone();
    }
}
