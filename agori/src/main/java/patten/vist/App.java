package patten.vist;

/**
 * Created by chauncy on 2018/7/26.
 */
public class App {

    public static void main(String[] args) {

        Directory root = new Directory("root");
        Directory directory1 = new Directory("1");
        Directory directory2 = new Directory("2");
        Directory directory3 = new Directory("3");
        root.add(directory1);
        root.add(directory2);
        root.add(directory3);
        root.accept(new ListVisitorImpl());

    }
}

