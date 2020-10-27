package deck;

import java.util.ArrayList;
import java.util.List;

public abstract class DeckTemplate {

    protected List<Card> cards = new ArrayList<>();

    public sDeckTemplate() {
        for (Suite suite : Suite.values()) {
            for (Value value : Value.values()) {
                if (value == Value.JOKER)
                    continue;
                cards.add(new Card(suite, value));
            }
        }
    }
}
