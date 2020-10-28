package ui;

import deck.Card;
import deck.Value;
import hand.Hand;
import hand.StandardHand;
import players.Player;

import java.util.List;
import java.util.Scanner;

public class Console implements UI{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void printPlayer(Player player) {
        System.out.print(Player.isHuman(player) ? "HUMAN " : "AI ");
        System.out.print(player.getName() + " ");
        lineBreak();
    }

    @Override
    public void printHand(Hand hand) {
        hand.getCards().stream().forEach(this::printCard);
        lineBreak();
    }

    @Override
    public void ask(Value cardValue, Player player) {
        System.out.println(player.getName() + ", do you have any " + cardValue.toString() + "s?");
    }

    @Override
    public boolean respond(Value cardValue) {
        return scanner.next().toUpperCase().startsWith("Y");
    }

    @Override
    public Player choosePlayer(List<Player> players) {
        System.out.println("Choose who to ask (Enter their number) ~");
        for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
            System.out.print(playerIndex + " - ");
            printPlayer(players.get(playerIndex));
        }
        return players.get(scanner.nextInt());
    }

    @Override
    public Value chooseValue() {
        System.out.println("Choose a value below~");
        for (int index = 2; index < 11; index++) {
            System.out.print(index + " ");
        }
        char[] faceCards = new char[]{'J', 'Q', 'K', 'A'};
        for (char faceCard : faceCards) {
            System.out.print(faceCard + " ");
        }
        String input = scanner.next();
        Value chosenValue = null;
        if (input.toUpperCase().startsWith("A")) {
            chosenValue = Value.ACE;
        } else if (input.toUpperCase().startsWith("K")) {
            chosenValue = Value.KING;
        } else if (input.toUpperCase().startsWith("Q")) {
            chosenValue = Value.QUEEN;
        } else if (input.toUpperCase().startsWith("J")) {
            chosenValue = Value.JACK;
        } else if (input.trim().equals("10")) {
            chosenValue = Value.TEN;
        }else if (input.trim().equals("9")) {
            chosenValue = Value.NINE;
        }else if (input.trim().equals("8")) {
            chosenValue = Value.EIGHT;
        }else if (input.trim().equals("7")) {
            chosenValue = Value.SEVEN;
        }else if (input.trim().equals("6")) {
            chosenValue = Value.SIX;
        }else if (input.trim().equals("5")) {
            chosenValue = Value.FIVE;
        }else if (input.trim().equals("4")) {
            chosenValue = Value.FOUR;
        }else if (input.trim().equals("3")) {
            chosenValue = Value.THREE;
        }else if (input.trim().equals("2")) {
            chosenValue = Value.TWO;
        } else {
            System.out.println("Enter valid card value");
            chooseValue();
        }
        System.out.println(chosenValue.toString());

        return chosenValue;
    }

    @Override
    public String inputName() {
        System.out.print("Enter you name: ");
        return scanner.next().trim();
    }

    @Override
    public void sendBookResults() {
        System.out.println("You made a book!");
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
