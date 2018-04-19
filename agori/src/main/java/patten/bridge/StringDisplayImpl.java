package patten.bridge;

import static java.lang.System.out;

/**
 * Created by chauncy on 2018/7/26.
 */
public class StringDisplayImpl extends DisplayImpl {
    @Override
    public void method01Impl() {
        out.println("string..o1");
    }

    @Override
    public void method02Impl() {
        out.println("string ..02");
    }
}
