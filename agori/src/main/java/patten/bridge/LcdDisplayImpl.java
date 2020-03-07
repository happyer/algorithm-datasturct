package patten.bridge;

public class LcdDisplayImpl extends Display {

    public LcdDisplayImpl(Colors colors) {
        super(colors);
    }

    @Override
    void display() {
        System.out.println("this is " + getCurrentColor() + " lcd display");
    }
}
