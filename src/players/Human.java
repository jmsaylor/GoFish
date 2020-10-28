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
        super(name, hand, ui);
        this.ui = ui;
    }

    public Human(Hand hand, UI ui) {
        super(ui.inputName(), hand, ui);
    }

    @Override
    public boolean ask(List<Player> allPlayers) {
        Player chosenPlayerToAsk = ui.choosePlayer(allPlayers);
        Value chosenValueToAsk = ui.chooseValue();
        return ask(chosenValueToAsk, chosenPlayerToAsk);
    }

    @Override
    public boolean respond(Value cardValue, Player player) {
        boolean knownAnswer = hasCard(cardValue);
        System.out.println(ui.respond(cardValue) != knownAnswer ? "You lied." : "Processing");
        return super.respond(cardValue, player);
    }

}


