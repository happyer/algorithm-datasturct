package patten.prototype.framework;

import java.util.HashMap;

/**
 * Created by chauncy on 2018/7/26.
 */
public class Manager {

    private HashMap<String, Product> hashMap = new HashMap<>();

    public void register(String name, Product product) {
        hashMap.put(name, product);
    }


    public Product create(String name) throws CloneNotSupportedException {
        return hashMap.get(name).cloneProduct();
    }


}
