import java.util.ArrayDeque;
import java.util.Deque;

public class CatapultBattle {
    private final Deque<Integer> walls = new ArrayDeque<>();

    public CatapultBattle(int[] initialWalls) {
        for (int w : initialWalls) if (w > 0) walls.addLast(w);
    }
    public boolean hasWalls() { return !walls.isEmpty(); }

    public void addWall(int w) {
        if (w > 0) walls.addLast(w);
    }
    public Deque<Integer> attackPile(int[] rocksLine) {

        Deque<Integer> rocks = new ArrayDeque<>();
        for (int r : rocksLine) rocks.push(r);

        while (!rocks.isEmpty() && !walls.isEmpty()) {
            int rock = rocks.pop();

            while (rock > 0 && !walls.isEmpty()) {
                int wall = walls.peekFirst();

                if (rock > wall) {
                    rock -= wall;
                    walls.removeFirst();
                } else if (wall > rock) {
                    walls.removeFirst();
                    walls.addFirst(wall - rock);
                    rock = 0;
                } else {
                    walls.removeFirst();
                    rock = 0;
                }
            }

            if (rock > 0 && walls.isEmpty()) {
                Deque<Integer> leftover = new ArrayDeque<>();
                leftover.addLast(rock);
                while (!rocks.isEmpty()) leftover.addLast(rocks.pop());
                return leftover;
            }
        }
        return new ArrayDeque<>();
    }

    public Deque<Integer> wallsView() {
        return walls;
    }
}
