package hand;

import deck.Card;
import game.Rules;
import players.Player;

import java.util.ArrayList;
import java.util.List;

public class StandardHand implements Hand {
    private Rules gameRules;
    private List<Card> books = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();


    public StandardHand(Player owner, Rules gameRules) {
        this.gameRules = gameRules;
    }

    public StandardHand(Player owner, Rules gameRules, Card[] cards) {
        this.gameRules = gameRules;
        for (Card card : cards) addCard(card);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public int getTotalBooks() {
        return 0;
    }

    @Override
    public void book() {

    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

}
