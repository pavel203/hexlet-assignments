package exercise;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

// BEGIN
public class MaxThread  extends  Thread {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    private int[] numbers;
    private int maxNumber;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        LOGGER.log(Level.INFO, "INFO: Thread " + Thread.currentThread().getName() + " started");
        maxNumber = Arrays.stream(numbers).max().getAsInt();
        LOGGER.log(Level.INFO, "INFO: Thread " + Thread.currentThread().getName() + " finished");
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
// END
