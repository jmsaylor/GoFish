package ui;

import deck.Value;
import hand.Hand;
import hand.StandardHand;
import players.Player;

import java.util.List;

public interface UI {

    void printPlayer(Player player);
    void printHand(Hand hand);

    void ask(Value cardValue, Player player);
    boolean respond(Value cardValue);

    Player choosePlayer(List<Player> players);
    Value chooseValue();

    String inputName();

    void sendBookResults();
}
