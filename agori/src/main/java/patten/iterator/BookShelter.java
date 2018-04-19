package patten.iterator;

/**
 * Created by chauncy on 2018/7/25.
 */
public class BookShelter implements Aggregate {

    private int last = 0;

    Book[] books;

    public BookShelter(int length) {
        this.books = new Book[length];
    }

    public void addBook(Book book) {
        this.books[last] = book;
        last++;
    }

    @Override
    public Iterator iterator() {
        return new BookIterator(this);
    }

    public int getLength() {
        return last;
    }

    public Object getByIndex(int index) {
        return books[index];
    }
}
