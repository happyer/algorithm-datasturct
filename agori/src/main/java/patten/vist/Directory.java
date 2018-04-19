package patten.vist;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by chauncy on 2018/7/26.
 */
public class Directory extends Entry {

    private ArrayList list = new ArrayList<>();

    private String name;


    public Directory(String name) {
        this.name = name;
    }


    public void add(Directory directory) {
        list.add(directory);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterator iterator() throws Exception {
        return  list.iterator();
    }
}
