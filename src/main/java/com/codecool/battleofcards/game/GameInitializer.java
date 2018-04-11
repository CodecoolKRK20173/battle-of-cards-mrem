package com.codecool.battleofcards.game;

import com.codecool.battleofcards.card.*;
import com.codecool.battleofcards.display.*;
import com.codecool.battleofcards.player.*;

import java.util.*;

class GameInitializer {
    private Deck deck;
    private List<Player> players;
    private List<Pile> piles;
    private int playersNumber;

    private GameView view = new GameView();
    private Scanner input = new Scanner(System.in);
    

    public GameInitializer() {}

    public void initializeGame() {
        playersNumber = this.askNumberOfPlayers();
        this.createDeck();
        this.dealCards();
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

    private void createHumanPlayer(int playersNumber) {
        for(int i = 0; i < playersNumber; i++) {
            // TODO check - compilation error
            //Player player = new HumanPlayer(view.askForName(), piles.get(i));
            //players.add(player);
        }
    }

    private void createHumanPlayer() {
        createHumanPlayer(this.playersNumber);
    }

    private void createComputerPlayer(int i) {
        Player computerPlayer;
        String level = this.askLevel();
        switch(level) {
            case "n": 
                // TODO check - compilation error
                // computerPlayer = new NormalAI(piles.get(i));
                //players.add(computerPlayer);
            case "h": 
                // TODO check - compilation error
                // computerPlayer = new HardAI(piles.get(i));
                // players.add(computerPlayer);
        }   
    }
    
    private void createPlayers() {
        players = new ArrayList<Player>();
        String mode = askGameMode();
        switch(mode) {
            case "pvp":     
                createHumanPlayer();
                break;
            case "pvc":
                int humanNumber = playersNumber - 1;
                createHumanPlayer(humanNumber);
                int pileNumber = humanNumber;
                createComputerPlayer(pileNumber);
                break;
            default:
                view.displayLine("There's no such option.");
        }     
    }

    private void dealCards() {
        this.piles = deck.deal(playersNumber);
    }

}