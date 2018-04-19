package patten.bridge;

import static java.lang.System.out;

/**
 * Created by chauncy on 2018/7/26.
 */
public class ReinforeceDisplay extends Display{

    public ReinforeceDisplay(DisplayImpl displayImpl) {
        super(displayImpl);
    }

    public void reinforece(){
        out.println("reinforece");
    }
}
