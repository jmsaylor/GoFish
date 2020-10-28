package players;

import deck.Card;
import deck.Value;
import hand.Hand;
import ui.UI;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class PlayerTemplate implements Player{
    private UUID id;
    private String name;
    private Hand hand;
    private UI ui;


    public PlayerTemplate(String name, Hand hand, UI ui)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.hand = hand;
        this.ui = ui;
    }

    public boolean ask(Value cardValue, Player player) {
        getUi().ask(cardValue, player);
       return player.respond(cardValue, this);
    }

    public boolean respond(Value cardValue, Player player){
        boolean response = hasCard(cardValue);
        if (response) {
            List<Card> filteredCards = hand.getCards().stream().filter(card -> card.VALUE == cardValue).collect(Collectors.toList());
            giveCards(filteredCards, player);
        }
        return response;
    }

    public String getName() {
        return name;
    }

    public boolean hasCard(Value value) {
        for (Card card : getCards()){
            if (card.VALUE == value)
                return true;
        }
        return false;
    }

    public void dealCard(Card card) {
        hand.addCard(card);
    }

    public void dealCards(List<Card> cards) {
        for (Card card : cards) {
            dealCard(card);
        }
    }

    public void giveCards(List<Card> cards, Player player) {
            player.dealCards(cards);
            for (Card card : cards){
                hand.getCards().remove(card);
            }

    }

    public void book() {
        if(hand.book()){
            ui.sendBookResults();
        }
    }


    public List<Card> getCards() {
        return hand.getCards();
    }

    public void showHand() {
        ui.printPlayer(this);
        ui.printHand(getHand());;
    }

    public Hand getHand() {
        return hand;
    }

    public UI getUi() {
        return ui;
    }

    public UUID getId() {
        return id;
    }
}
