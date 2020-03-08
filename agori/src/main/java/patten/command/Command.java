package patten.command;


/**
 * 只关心命令,而不关系具体的实现,执行过程,将动作转换为命令
 * 具体的执行子类去实现,通常都是一个无参数的
 */
public interface Command {

    /**
     * 不关系具体的实现,值负者下达命令即可
     */
    void execute();


}
