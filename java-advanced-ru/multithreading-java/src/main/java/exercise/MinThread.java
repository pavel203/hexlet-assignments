package exercise;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

// BEGIN
public class MinThread  extends  Thread {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    private int[] numbers;
    private int minNumber;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        LOGGER.log(Level.INFO, "INFO: Thread " + Thread.currentThread().getName() + " started");
        minNumber = Arrays.stream(numbers).min().getAsInt();
        LOGGER.log(Level.INFO, "INFO: Thread " + Thread.currentThread().getName() + " finished");
    }

    public int getMinNumber() {
        return minNumber;
    }
}
// END
