package com.codecool.battleofcards.game;

import com.codecool.battleofcards.card.*;
import com.codecool.battleofcards.display.*;
import com.codecool.battleofcards.player.*;

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
        view.displayInputPrompt("Choose mode: PvP or PvC?");
        return input.nextLine();
    }

    private int askNumberOfPlayers() {
        view.displayInputPrompt("How many players?(1-4)");
        return input.nextInt();
    }

    private String askName() {
        view.displayInputPrompt("What's your name?");
        return input.nextLine();
    }

    private void createHumanPlayer(int humanNumber) {
        for(int i = 0; i < humanNumber; i++) {
            Player player = new HumanPlayer(askForName(), piles[i]);
            players.add(player);
        }
    }

    private void createComputerPlayer(int i) {
            Player player = new ComputerPlayer("AI", piles[i]);
            players.add(player);
        }
    
    private void createPlayers() {
        players = new ArrayList<Player>();
        String mode = askGameMode();
        switch(mode) {
            case "PvP": case "PVP": case "pvp":     
                createHumanPlayer(playersNumber);
                break;
            case "PvC": case "PVC": case "pvc":
                humanNumber = playersNumber - 1;
                createHumanPlayer(humanNumber);
                int pileNumber = humanNumber;
                createComputerPlayer(pileNumber);
        }     
    }

    private void dealCards(int playersNumber) {
        this.piles = deal(playersNumber);
    }

}