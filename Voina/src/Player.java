import java.util.Iterator;
import java.util.LinkedHashSet;

public class Player {
    private final LinkedHashSet<Integer> deck = new LinkedHashSet<>();

    public Player(Iterable<Integer> initial) {
        for (Integer n : initial) deck.add(n);
    }

    public boolean hasCards() { return !deck.isEmpty(); }
    public int size() { return deck.size(); }

    public Integer drawTop() {
        Iterator<Integer> it = deck.iterator();
        Integer top = it.next();
        it.remove();
        return top;
    }
    public void addToBottom(int... nums) {
        for (int n : nums) deck.add(n);
    }
}
