public class VoinaGame {
    private final Player p1;
    private final Player p2;

    public VoinaGame(Player p1, Player p2) { this.p1 = p1; this.p2 = p2; }

    public String play() {
        for (int round = 1; round <= 50; round++) {
            if (!p1.hasCards() || !p2.hasCards()) break;

            int a = p1.drawTop();
            int b = p2.drawTop();

            if (a > b) {
                p1.addToBottom(a, b);
            } else if (b > a) {
                p2.addToBottom(a, b);
            }
        }
        if      (p1.size() > p2.size()) return "First player win!";
        else if (p2.size() > p1.size()) return "Second player win!";
        else                            return "Draw!";
    }
}
