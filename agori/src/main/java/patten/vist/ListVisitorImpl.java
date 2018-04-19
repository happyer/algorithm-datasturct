package patten.vist;


import java.util.Iterator;

import static java.lang.System.out;

/**
 * Created by chauncy on 2018/7/26.
 */
public class ListVisitorImpl implements Visitor {
    @Override
    public void visit(File file) {
        out.println(file.getName());
    }

    @Override
    public void visit(Directory directory) {
        try {
            out.println("dir=" + directory.getName());
            Iterator iterator =  directory.iterator();
            while (iterator.hasNext()) {
                Directory directory1 = (Directory) iterator.next();
                directory1.accept(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
