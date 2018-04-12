package com.codecool.battleofcards.game;

import com.codecool.battleofcards.card.*;
import com.codecool.battleofcards.display.*;
import com.codecool.battleofcards.player.*;

import java.util.*;

public class GameInitializer {
    private final String FILE_NAME;
    private Deck deck;
    private List<Player> players;
    private List<Pile> piles;
    private int playersNumber;

    private GameView view = new GameView();
    private Scanner input;
    

    public GameInitializer(String fileName) {
        FILE_NAME = fileName;
        this.input = new Scanner(System.in);
    }

    public Game initializeGame() {
        this.view.clearScreen();
        this.playersNumber = this.askNumberOfPlayers();
        this.createDeck();
        this.dealCards();
        this.createPlayers();

        return new Game(this.players);
    }

    private void createDeck() {
        this.deck = new Deck(FILE_NAME);
    }

    private String askGameMode() {
        view.displayInputPrompt("Choose game mode (PvP or PvC)");
        return input.nextLine().toLowerCase();
    }

    private int askNumberOfPlayers() {
        view.displayInputPrompt("Select players number (between 2 and 4)?");
        return (int) Integer.parseInt(input.nextLine());
    }

    private String askForName() {
        view.displayInputPrompt("Enter your name");
        return input.nextLine();
    }

    private String askLevel() {
        view.displayInputPrompt("Choose level normal or hard [n/h]");
        return input.nextLine().toLowerCase();
    }

    private void createHumanPlayer(int playersNumber) {
        for(int i = 0; i < playersNumber; i++) {
            Player player = new HumanPlayer(askForName(), piles.get(i));
            players.add(player);
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
        players = new ArrayList<>();

        boolean isNotValid = true;

        while (isNotValid) {
            try {
                String mode = askGameMode();
                switch(mode) {
                    case "pvp":
                        isNotValid = false;
                        createHumanPlayer();
                        break;
                    case "pvc":
                        isNotValid = false;
                        int humanNumber = playersNumber - 1;
                        createHumanPlayer(humanNumber);
                        int pileNumber = humanNumber;
                        createComputerPlayer(pileNumber);
                        break;
                    default:
                        throw new IllegalArgumentException("There's no such option");
                }
            } catch (IllegalArgumentException e) {
                view.displayLine(e.getMessage());
            }
        }
    }

    private void dealCards() {
        this.piles = this.deck.deal(playersNumber);
    }

}