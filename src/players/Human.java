package players;

import deck.Card;
import deck.Value;
import hand.Hand;
import hand.StandardHand;
import ui.UI;

import java.util.List;

public class Human extends PlayerTemplate implements Player {
    public UI ui;

    public Human(String name, Hand hand, UI ui) {
        super(name, hand);
        this.ui = ui;
    }

    @Override
    public boolean ask() {

    }
}


