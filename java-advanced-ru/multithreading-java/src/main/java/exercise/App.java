package exercise;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        Map<String, Integer> minMax = new HashMap<>();
        var calcMaxTask = new MaxThread(numbers);
        var calcMinTask = new MinThread(numbers);

        calcMaxTask.start();
        calcMinTask.start();

        try {
            calcMinTask.join();
            calcMaxTask.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        minMax.put("min", calcMinTask.getMinNumber());
        minMax.put("max", calcMaxTask.getMaxNumber());
        return minMax;
    }
    // END
}
