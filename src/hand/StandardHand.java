package hand;

import deck.Card;
import deck.Value;
import game.Rules;
import players.Player;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class StandardHand implements Hand {
    private Rules gameRules;
    private List<Card> books = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();


    public StandardHand(Rules gameRules) {
        this.gameRules = gameRules;
    }

    public StandardHand(Rules gameRules, Card[] cards) {
        this.gameRules = gameRules;
        for (Card card : cards) addCard(card);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public int getTotalBooks() {
        return (books.size() / gameRules.getMinimumCardsForBook());
    }

    @Override
    public boolean book() {
        boolean madeABook = false;
        EnumMap<Value, Integer> valueCounts = new EnumMap<Value, Integer>(Value.class);
        for (Card card : cards) {
            if (valueCounts.containsKey(card.VALUE)) {
                int temp = valueCounts.get(card.VALUE);
                temp++;
                valueCounts.put(card.VALUE, temp);
            } else {
                valueCounts.put(card.VALUE, 1);
            }
        }
        for (Value value : valueCounts.keySet()) {
            if (valueCounts.get(value) >= gameRules.getMinimumCardsForBook()) {
                madeABook = true;
                cards.stream().forEach(card -> {
                    books.add(card);
                    cards.remove(card);
                });
            }
        }
        return madeABook;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

}
