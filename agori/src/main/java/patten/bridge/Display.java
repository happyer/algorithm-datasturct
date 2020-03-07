package patten.bridge;

import java.util.Collections;

/**
 * Created by chauncy on 2018/7/26.
 */
public abstract class Display {

    private Colors colors;


    public Display(Colors colors) {
        this.colors = colors;
    }

    protected String getCurrentColor(){
        return colors.getColor();
    }

    abstract void display();
}
