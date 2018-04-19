package patten.factory.card;

import patten.factory.framework.Factory;
import patten.factory.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chauncy on 2018/7/26.
 */
public class FactoryImpl extends Factory {

    private List<Product> list = new ArrayList<>();
    @Override
    protected void registerProduct(Product product) {
        list.add(product);
    }

    @Override
    protected Product createProduct(String owner) {
        return new ConcreteProduct(owner);
    }

    public List<Product> getList() {
        return list;
    }
}
