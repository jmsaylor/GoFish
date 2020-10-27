package players;

public interface Player {
    void ask();
    void respond();

    static boolean isHuman(Player player) { return player instanceof Human; }
}
