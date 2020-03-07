package patten.command;


/**
 * 只关心命令,而不关系具体的实现,执行过程,将动作转换为命令
 */
public interface Command {

    /**
     * 不关系具体的实现,值负者下达命令即可
     */
    void execute();


}
