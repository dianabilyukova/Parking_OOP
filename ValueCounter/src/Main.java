import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        double[] arr = Arrays.stream(line.trim().split("\\s+"))
                .filter(s -> !s.isBlank())
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> counts = ValueCounter.count(arr);
        counts.forEach((val, times) ->
                System.out.println(ValueCounter.fmt(val) + " - " + times + " times"));
    }
}