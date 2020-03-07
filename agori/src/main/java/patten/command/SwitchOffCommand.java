package patten.command;


/**
 * 在具体的实现中,需要按照自state 来进行执行
 */
public class SwitchOffCommand implements Command {

    private Receiver receiver;

    public SwitchOffCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.process("turn off");
    }
}
