package players;

import deck.Card;
import deck.Value;
import hand.Hand;
import hand.StandardHand;
import ui.UI;

import java.util.List;
import java.util.Random;

public class AI extends PlayerTemplate implements Player {
    private static int extantAI = 0;
    private static Random random = new Random();


    public AI(Hand hand, UI ui) {
        super(getNewAIName(), hand, ui);
    }


    @Override
    public boolean ask(List<Player> allPlayers) {
        int randomPlayerNumber =  (int) (allPlayers.size() * random.nextFloat());
        Player randomPlayer = allPlayers.get(randomPlayerNumber);
        int randomCardNumber = (int) (getCards().size() * random.nextFloat());
        Value randomHandValue = getCards().get(randomCardNumber).VALUE;
        return ask(randomHandValue, randomPlayer);

    }


    private static String getNewAIName() {
        String[] names = {"Xerxes", "Nutella", "Robox"};
        return names[extantAI++];
    }

    private static int getRandomNumber(int bound) {
        return random.nextInt(bound);
    }
}
