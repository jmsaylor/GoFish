package deck;

import java.util.*;

public abstract class DeckTemplate {

    protected Queue<Card> cards = new LinkedList<>();

    public DeckTemplate() {
        for (Suite suite : Suite.values()) {
            for (Value value : Value.values()) {
                if (value != Value.JOKER)
                    cards.add(new Card(suite, value));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        List<Card> temp = new ArrayList<>();

        while (cards.size() > 0) {
            Card card = cards.poll();
            temp.add(card);
        }

        while (temp.size() > 0) {
            int remainingCards = temp.size();
            int randomIndex = random.nextInt(remainingCards);
            Card randomCard = temp.get(randomIndex);
            cards.add(randomCard);
            temp.remove(randomCard);
        }

    }

    public Card pull() {
        return cards.poll();
    }

    public int getRemainingCardCount() {
        return cards.size();
    }
}
