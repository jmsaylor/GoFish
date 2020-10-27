package game;


import deck.Card;
import deck.Value;
import hand.Hand;

import java.util.EnumMap;
import java.util.List;

public class GameBasics implements Rules{


    @Override
    public Value book(Hand hand) {
        EnumMap<Value, Integer> counts = new EnumMap<>(Value.class);
        for (Card card : hand.getCards()) {
            if (!counts.containsKey(card.VALUE)) {
                counts.put(card.VALUE, 1);
            } else {
                int temp = counts.get(card.VALUE);
                temp++;
                counts.put(card.VALUE, temp);
            }
        }

        for (Value value : Value.values()) {
            if (counts.get(value) >= 4)
                return value;
        }

        return null;
    }

    @Override
    public boolean isWinner(Hand hand, List<Hand> allHands) {
        return false;
    }
}
