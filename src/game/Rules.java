package game;

import deck.Value;
import hand.Hand;

import java.util.List;

public interface Rules {
    Value book(Hand hand);
    boolean isWinner(Hand hand, List<Hand> allHands);
}
