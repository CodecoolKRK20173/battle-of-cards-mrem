package com.codecool.battleofcards.game;

import main.java.com.codecool.battleofcards.card.*;
import main.java.com.codecool.battleofcards.display.*;
import main.java.com.codecool.battleofcards.player.*;

import java.util.List;
import java.util.*;

class GameInitializer {
    private Deck deck;
    private List<Player> players;
    private int playersNumber;
    private List<Pile> piles;

    private GameView view = new GameView();
    private Scanner input = new Scanner(System.in);
    

    public GameInitializer() {}

    public void initializeGame() {
        playersNumber = this.askNumberOfPlayers();
        this.createDeck();
        this.dealCards(playersNumber);
        this.createPlayers();
    }

    private void createDeck() {
        deck = new Deck("statistics.csv");
    }

    private String askGameMode() {
        view.displayLine("Choose mode: PvP or PvC?");
        return input.nextLine().toLowerCase();
    }

    private int askNumberOfPlayers() {
        view.displayLine("How many players?(1-4)?");
        return input.nextInt();
    }

    private String askName() {
        view.displayLine("What's your name?");
        return input.nextLine();
    }

    private String askLevel() {
        view.displayInputPrompt("Choose level normal or hard[n/h]");
        return input.nextLine().toLowerCase();
    }

    private void createHumanPlayer(int humanNumber) {
        for(int i = 0; i < humanNumber; i++) {
            Player player = new HumanPlayer(view.askForName(), piles.get(i));
            players.add(player);
        }
    }

    private void createComputerPlayer(int i) {
            Player computerPlayer;
            String level = view.askLevel();
            switch(level) {
                case "n": 
                    computerPlayer = new NormalAI(piles.get(i));
                    players.add(computerPlayer);
                case "h": 
                    computerPlayer = new HardAI(piles.get(i));
                    players.add(computerPlayer);
            }   
        }
    
    private void createPlayers() {
        players = new ArrayList<Player>();
        String mode = askGameMode();
        switch(mode) {
            case "pvp":     
                createHumanPlayer(playersNumber);
                break;
            case "pvc":
                int humanNumber = playersNumber - 1;
                createHumanPlayer(humanNumber);
                int pileNumber = humanNumber;
                createComputerPlayer(pileNumber);
                break;
            default:

        }     
    }

    private void dealCards(int playersNumber) {
        this.piles = deck.deal(playersNumber);
    }

}