package patten.iterator;

/**
 * Created by chauncy on 2018/7/25.
 */
public class App {

    /**
     * 引入 iterator 的目的是将 遍历与实现进行一个分离,
     * 下面的循环,就能提先出来,在遍历的时候并不需要依赖具体的某个类的实现
     *
     * @param args
     */
    public static void main(String[] args) {
        BookShelter bookShelter = new BookShelter(10);
        bookShelter.addBook(new Book("this"));
        bookShelter.addBook(new Book("this2"));
        bookShelter.addBook(new Book("this2"));
        Iterator iterator = bookShelter.iterator();
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println("book = " + book.getName());
        }

    }
}
