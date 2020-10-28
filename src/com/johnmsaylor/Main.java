package com.johnmsaylor;

public class Main {

    public static void main(String[] args) {

        var game = new GoFish();

        game.addNewHumanPlayer("John");
        game.addNewAIPlayer();

        game.play();
    }
}
