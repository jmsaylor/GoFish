package players;

import deck.Card;
import deck.Value;
import hand.Hand;
import hand.StandardHand;

import java.util.List;

public class AI extends PlayerTemplate implements Player {
    private static int extantAI = 0;
    public AI(Hand hand) {
        super(getNewAIName(), hand);
    }



    private static String getNewAIName() {
        String[] names = {"Xerxes", "Nutella", "Robox"};
        return names[extantAI++];
    }

    @Override
    public boolean ask() {

    }
}
