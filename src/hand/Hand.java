package hand;

import deck.Card;

import java.util.List;

public interface Hand {

    int getTotalBooks();
    void book();

    List<Card> getCards();
}
