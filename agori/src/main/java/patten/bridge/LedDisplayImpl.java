package patten.bridge;

public class LedDisplayImpl extends Display {

    public LedDisplayImpl(Colors colors) {
        super(colors);
    }

    @Override
    void display() {
        System.out.println(" this is " + getCurrentColor() + " led display");
    }
}
