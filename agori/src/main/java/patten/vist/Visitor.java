package patten.vist;

/**
 * Created by chauncy on 2018/7/26.
 */
public interface Visitor {
    void visit(File file);
    void visit(Directory file);
}
