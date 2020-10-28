package deck;

import java.util.*;

//TODO: integrate DeckTemplate
public class Deck52 extends DeckTemplate implements Deck{
    private final Integer NUMBER_OF_CARDS = 52;
    public Queue<Card> cards = new LinkedList<>();

    public Deck52() {
        super();
    }

}
