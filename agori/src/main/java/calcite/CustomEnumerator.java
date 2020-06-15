package calcite;

import java.io.BufferedReader;
import java.io.IOException;
import org.apache.calcite.linq4j.Enumerator;
import org.apache.calcite.util.Source;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/5
 */
public class CustomEnumerator<E> implements Enumerator<E> {

    private E current;
    private BufferedReader reader;

    public CustomEnumerator(Source source) {

        try {
            reader = new BufferedReader(source.reader());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public E current() {
        return current;
    }

    @Override
    public boolean moveNext() {

        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null) {
            return false;
        }
        current = (E) new Object[]{line};
        return true;
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("not support operation");
    }

    @Override
    public void close() {

    }
}
