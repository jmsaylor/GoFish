package hand;

import deck.Card;

import java.util.List;

public interface Hand {

    int getTotalBooks();
    boolean book();

    void addCard(Card card);
    List<Card> getCards();
}
