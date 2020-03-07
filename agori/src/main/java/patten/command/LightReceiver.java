package patten.command;

public class LightReceiver implements Receiver {

    @Override
    public void process(String arg) {
        System.out.println("this is light process " + arg);
    }
}
