import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int waves = Integer.parseInt(nextNonBlank(sc));
        int[] initialWalls = parseInts(nextNonBlank(sc));
        CatapultBattle battle = new CatapultBattle(initialWalls);

        for (int wave = 1; wave <= waves && battle.hasWalls(); wave++) {
            int[] rocks = parseInts(nextNonBlank(sc));

            if (wave % 3 == 0) {
                int add = Integer.parseInt(nextNonBlank(sc));
                battle.addWall(add);
            }

            Deque<Integer> leftover = battle.attackPile(rocks);
            if (!battle.hasWalls()) {
                if (leftover.isEmpty()) {
                    System.out.println("Rocks left:");
                } else {
                    System.out.println("Rocks left: " + joinDeque(leftover));
                }
                return;
            }
        }


        System.out.println("Walls left: " + joinDeque(battle.wallsView()));
    }


    private static String nextNonBlank(Scanner sc) {
        String line;
        do { line = sc.nextLine(); } while (line != null && line.trim().isEmpty());
        return line.trim();
    }

    private static int[] parseInts(String line) {
        if (line.isEmpty()) return new int[0];
        String[] parts = line.trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);
        return arr;
    }

    private static String joinDeque(Deque<Integer> dq) {
        return dq.stream().map(String::valueOf).collect(Collectors.joining(", "));

    }
}