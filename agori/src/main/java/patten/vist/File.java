package patten.vist;


import java.util.Iterator;

/**
 * Created by chauncy on 2018/7/26.
 */
public class File extends Entry {


    private String name;


    public File(String name) {
        this.name = name;
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
        throw new Exception("not support");
    }
}
