package patten.bridge;

/**
 * Created by chauncy on 2018/7/26.
 */
public class App {


    /**
     * bridge 显示器才分为 lcd led etc  ,颜色分为 red .blue etc ,需要给他们进行组合
     *
     * @param args
     */
    public static void main(String[] args) {
        Display lcdRedDisplay = new LcdDisplayImpl(new RedColor());
        lcdRedDisplay.display();

        Display ledRedDisPlay = new LedDisplayImpl(new RedColor());
        ledRedDisPlay.display();
    }
}
