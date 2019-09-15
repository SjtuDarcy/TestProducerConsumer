import java.util.Random;

public class Utils {
    public static void randomDelay(int delayNum) {
        try {
            Thread.sleep(new Random().nextInt(delayNum));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
