package com.codecool.battleofcards.game;

import com.codecool.battleofcards.player.*;
import com.codecool.battleofcards.display.*;

import java.util.List;

public class Game {

    private List<Player> players;
    private Player activePlayer;
    private Table table;
    private boolean isActive;
    private GameView gameView;

    public Game(List<Player> players) {
        this.players = players;
        this.table = new Table();
        this.gameView = new GameView();
        this.isActive = true;
    
    }

    private void play() {
        while (this.isActive) {
            handleRound();
        }
    }

    private void handleRound() {

    }

    private void showCard(Player player) {

    }

    private void showCards(List<Player>) {

    }

    private void checkIfWon() {
        for (Player player : players) {
            if (player.getCards().isEmpty()) {
                this.isActive = false;
            }
        }
    }

    private Player findPlayer() {
        for (Player player : players) {
            if (player.getCards().contains(table.getWinningCard())) {
                return player;
            }
        }
    }
}