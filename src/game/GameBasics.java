package game;

public class GameBasics implements Rules{


    @Override
    public int getMinimumCardsForBook() {
        return 4;
    }

    @Override
    public int getStartingNumberOfCards() {
        return 5;
    }
}
