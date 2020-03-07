package patten.command;

public class SwitchOnCommand implements Command {

    private Receiver receiver;

    public SwitchOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {

        receiver.process("turn on");
    }
}
