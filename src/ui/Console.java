package ui;

import deck.Card;
import hand.StandardHand;
import players.Human;
import players.Player;

import java.util.List;
import java.util.Scanner;

public class Console implements UI{
    private Scanner scanner = new Scanner(System.in);


    @Override
    public void publicShowHand(StandardHand hand) {
        List<Card> cards = hand.getCards();
        printHiddenCard();
        final int REST_OF_CARDS = cards.size() - 1;
        for (int i = 1; i <= REST_OF_CARDS; i++) {
            printCard(cards.get(i));
        }
    }

    @Override
    public void showHandAllCards(StandardHand hand) {
        List<Card> cards = hand.getCards();
        final Card FIRST_CARD = cards.get(0);
        printCard(FIRST_CARD);
        final int REST_OF_CARDS = cards.size() - 1;
        for (int i = 1; i <= REST_OF_CARDS; i++) {
            printCard(cards.get(i));
        }
    }

    @Override
    public void showAllHandsInGame(List<StandardHand> hands) {
        for (StandardHand hand : hands) {
            printPlayer(hand.getOwner());
            publicShowHand(hand);
            lineBreak();
        }
        lineBreak();
    }

    @Override
    public boolean promptForHit() {
        return getAnswer("Hit?");
    }

    @Override
    public int inputBet() {
        System.out.print("Bet Amount: ");
        return scanner.nextInt();
    }

    @Override
    public boolean getAnswer(String string) {
        System.out.print(string);
        System.out.print(" (Y/n)");
        return scanner.next().toUpperCase().startsWith("Y");
    }


    public void printPlayer(Player player) {


    }

    public void printCard(Card card) {
        printCardValue(card);
        printCardSuite(card);
        System.out.print(" | ");
    }

    private void printCardValue(Card card) {
        switch (card.VALUE)
        {
            case TWO:
                System.out.print("2");
                break;
            case THREE:
                System.out.print("3");
                break;
            case FOUR:
                System.out.print("4");
                break;
            case FIVE:
                System.out.print("5");
                break;
            case SIX:
                System.out.print("6");
                break;
            case SEVEN:
                System.out.print("7");
                break;
            case EIGHT:
                System.out.print("8");
                break;
            case NINE:
                System.out.print("9");
                break;
            case TEN:
                System.out.print("10");
                break;
            case JACK:
                System.out.print("J");
                break;
            case QUEEN:
                System.out.print("Q");
                break;
            case KING:
                System.out.print("K");
                break;
            case ACE:
                System.out.print("A");
                break;
        }
    }

    private void printCardSuite(Card card) {
        switch (card.SUITE)
        {
            case CLUB:
              System.out.print("\u2663");
                break;
            case HEART:
                System.out.print("\u2665");
                break;
            case SPADE:
                System.out.print("\u2664");
                break;
            case DIAMOND:
                System.out.print("\u2666");
        }
    }

    private void lineBreak(){
        System.out.println();
    }

    private void printHiddenCard(){
        System.out.print("XX | ");
    }

}
