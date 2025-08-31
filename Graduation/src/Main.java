import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final DecimalFormat DF = new DecimalFormat("#.################");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(skipBlanks(sc));

        Academy academy = new Academy();
        for (int i = 0; i < n; i++) {
            String name = skipBlanks(sc);
            String gradesLine = skipBlanks(sc);
            List<Double> grades = parseDoubles(gradesLine);
            academy.add(name, grades);
        }

        for (Student s : academy.studentsInOrder()) {
            System.out.println(s.getName() + " is graduated with " + DF.format(s.average()));
        }
    }

    private static String skipBlanks(Scanner sc) {
        String line;
        do { line = sc.nextLine(); } while (line != null && line.isBlank());
        return line.trim();
    }

    private static List<Double> parseDoubles(String line) {
        if (line == null || line.isBlank()) return Collections.emptyList();
        return Arrays.stream(line.trim().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}