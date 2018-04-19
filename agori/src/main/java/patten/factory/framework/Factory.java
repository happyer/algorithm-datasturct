package patten.factory.framework;

/**
 * Created by chauncy on 2018/7/26.
 */
public abstract class Factory {



    public Product create(String owner){
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    protected abstract void registerProduct(Product product);

    protected abstract Product createProduct(String owner);
}
