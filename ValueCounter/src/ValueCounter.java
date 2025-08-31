import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class ValueCounter {
    private static final DecimalFormat DF = new DecimalFormat("#.###############");

    public static Map<Double, Integer> count(double[] arr) {
        Map<Double, Integer> map = new LinkedHashMap<>();
        for (double v : arr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        return map;
    }
    public static String fmt(double d) {
        return DF.format(d);
    }
}
