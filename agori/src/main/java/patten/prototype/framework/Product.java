package patten.prototype.framework;

/**
 * Created by chauncy on 2018/7/26.
 */
public interface Product extends Cloneable {


    void use();

    Product cloneProduct() throws CloneNotSupportedException;

}
