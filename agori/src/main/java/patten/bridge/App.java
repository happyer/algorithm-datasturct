package patten.bridge;

/**
 * Created by chauncy on 2018/7/26.
 */
public class App {


    /**
     * bridge 可以区分度 类的功能层次机构(Reinforce 与 display ) 和 类的实现层次结构(DisplayImpl 与StringDisplayImpl)
     * @param args
     */
    public static void main(String[] args) {

        Display display = new Display(new StringDisplayImpl());
        display.method1();

        ReinforeceDisplay reinforeceDisplay = new ReinforeceDisplay(new StringDisplayImpl());
        reinforeceDisplay.reinforece();


    }
}
