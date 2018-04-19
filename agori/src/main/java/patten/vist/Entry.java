package patten.vist;


import java.util.Iterator;

/**
 * Created by chauncy on 2018/7/26.
 */
public abstract class Entry implements Element {


    public abstract String getName();
    public abstract Iterator iterator() throws Exception;
}
