package com.codecool.battleofcards.game;

import com.codecool.battleofcards.card.Card;
import com.codecool.battleofcards.card.comparator.CardComparatorFactory;
import com.codecool.battleofcards.player.*;
import com.codecool.battleofcards.display.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private GameView gameView;

    private List<Player> players;
    private Player activePlayer;

    private CardComparatorFactory cardComparators;
    private Table table;

    private boolean isActive;

    public Game(List<Player> players) {
        this.gameView = new GameView();
        this.players = players;
        this.cardComparators = new CardComparatorFactory();
        this.table = new Table();
        this.isActive = true;
    
    }

    public void play() {
        this.gameView.clearScreen();
        this.activePlayer = this.players.get(0);
        while (this.isActive) {
            gameView.clearScreen();
            handleRound();
            waitForAction();
        }
    }

    private void handleRound() {
        // Active player peeks his top card
        this.gameView.displayLine("Current player: " + this.activePlayer.getName());
        this.gameView.displayEmptyLine();
        Card activePlayerTopCard = this.activePlayer.getCards().peekTopCard();
        showCard(activePlayerTopCard);
        this.gameView.displayEmptyLine();

        // Active player chooses comparison attribute
        this.gameView.displayInputPrompt("Select comparison attribute");
        int playerChoice = this.activePlayer.getChoice();
        table.setCardComparator(cardComparators.getCardComparator(playerChoice));
        this.gameView.clearScreen();

        // Players top cards are gathered
        List<Card> roundCards = new ArrayList<>();
        for (Player player : this.players) {
            roundCards.add(player.getCards().peekTopCard());
        }

        // Players top cards are showed
        showCards(roundCards);

        // Round is being resolved
        table.resolveRound(roundCards);
        if (table.isRoundResolved()) {
            Player winner = findWinningCardOwner();
            takePlayersTopCards();
            winner.addCards(table.getRoundTrophy());
            this.gameView.displayLine(String.format("Winning card is %s, so the winner is %s", table.getWinningCard().getName(),
                                                                                               winner.getName()));
            this.activePlayer = winner;
        }

        checkIfWon();
    }

    private void takePlayersTopCards() {
        for (Player player : this.players) {
            player.getCards().getTopCard();
        }
    }

    private void showCard(Card card) {
         this.gameView.displayCard(card);
    }

    private void showCards(List<Card> cards) {
        this.gameView.displayTable(cards);
    }

    private void checkIfWon() {
        for (Player player : players) {
            if (player.getNumOfCards() == 0) {
                this.isActive = false;
            }
        }
    }

    private Player findWinningCardOwner() {
        for (Player player : this.players) {
            if (player.hasCard(table.getWinningCard())) {
                return player;
            }
        }
        return null;
    }

    private void waitForAction() {
        this.gameView.displayInputPrompt("Press enter to continue");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
    }
}