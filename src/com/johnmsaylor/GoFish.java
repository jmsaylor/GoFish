package com.johnmsaylor;

import deck.Deck;
import deck.Deck52;
import game.GameBasics;
import game.Rules;
import hand.Hand;
import hand.StandardHand;
import players.AI;
import players.Human;
import players.Player;
import ui.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GoFish {

    private List<Player> players = new ArrayList<>();
    private Rules rules = new GameBasics();
    private Deck cards = new Deck52();

    public GoFish() {
        cards.shuffle();
    }

    public void play(){
        deal();
        getPlayers().stream().forEach(Player::showHand);
        System.out.println();
        System.out.println("LET'S START!");
        do {
            for (Player player : getPlayers()) {
                turn(player);
            }
        } while (cards.getRemainingCardCount() > 0);

    }
    public void turn(Player player){
        player.showHand();
        if (!player.ask(getFilteredPlayerList(player))) {
            System.out.println("Go Fish!");
            player.dealCard(cards.pull());
        }
        player.showHand();
        player.book();
    }

    public void deal(){
        for (int i = 0; i < rules.getStartingNumberOfCards(); i++){
            for (Player player : getPlayers()) {
                player.dealCard(cards.pull());
            }
        }
    }

    public void addNewHumanPlayer(){
        players.add(new Human(createNewHand(), new Console()));
    }
    public void addNewHumanPlayer(String name){
        players.add(new Human(name, createNewHand(), new Console()));
    }

    public void addNewAIPlayer() {
        players.add(new AI(createNewHand(), new Console()));
    }

    private Hand createNewHand() {
        return new StandardHand(rules);
    }


    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> getFilteredPlayerList(Player player) {
        return getPlayers().stream().filter(p -> p.getId() != player.getId()).collect(Collectors.toList());
    }

}
