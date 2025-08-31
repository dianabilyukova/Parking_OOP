import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> first = parseLineOfInts(sc.nextLine());
        List<Integer> second = parseLineOfInts(sc.nextLine());

        Player p1 = new Player(first);
        Player p2 = new Player(second);

        System.out.println(new VoinaGame(p1, p2).play());
    }

    private static List<Integer> parseLineOfInts(String line) {
        if (line == null) return Collections.emptyList();
        return Arrays.stream(line.trim().split("\\s+"))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}