package patten.command;

public class App {


    public static void main(String[] args) {
        Receiver receiver = new LightReceiver();

        Command offCommand = new SwitchOffCommand(receiver);
        Command onCommand = new SwitchOnCommand(receiver);

        offCommand.execute();
        onCommand.execute();

    }
}
