package players;

import deck.Card;
import deck.Value;
import hand.Hand;

import java.util.List;
import java.util.UUID;

public interface Player {
    boolean ask(List<Player> allPlayers);
//    boolean ask(Value cardValue, Player player);
    boolean respond(Value cardValue, Player player);

    void giveCards(List<Card> cards, Player player);
    void dealCards(List<Card> cards);
    void dealCard(Card card);

    void book();

    String getName();
    UUID getId();
    void showHand();

    static boolean isHuman(Player player) { return player instanceof Human; }
}
