package patten.iterator;

/**
 * Created by chauncy on 2018/7/25.
 */
public class BookIterator implements Iterator {

    private BookShelter bookShelter;


    private int index;

    public BookIterator(BookShelter bookShelter) {

        this.bookShelter = bookShelter;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index <= (bookShelter.getLength() - 1);
    }

    @Override
    public Object next() {
        Object o = bookShelter.getByIndex(index);
        index++;
        return o;
    }
}
