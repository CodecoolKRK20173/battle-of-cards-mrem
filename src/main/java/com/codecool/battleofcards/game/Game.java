package com.codecool.battleofcards.game;

import com.codecool.battleofcards.card.Card;
import com.codecool.battleofcards.card.comparator.CardComparatorFactory;
import com.codecool.battleofcards.player.*;
import com.codecool.battleofcards.display.*;

import java.util.ArrayList;
import java.util.List;

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

    private void play() {
        this.activePlayer = this.players.get(0);
        while (this.isActive) {
            handleRound();
        }
    }

    private void handleRound() {
        // Active player peeks his top card
        Card activePlayerTopCard = this.activePlayer.getCards().peekTopCard();
        showCard(activePlayerTopCard);

        // Active player chooses comparison attribute
        int playerChoice = this.activePlayer.getChoice();
        table.setCardComparator(cardComparators.getCardComparator(playerChoice));

        // Players top cards are gathered
        List<Card> roundCards = new ArrayList<Card>();
        for (Player player : this.players) {
            roundCards.add(player.getCards().getTopCard());
        }

        // Players top cards are showed
        showCards();

        // Round is being resolved
        table.resolveRound(roundCards);
        if (table.isRoundResolved()) {
            Player winner = findWinningCardOwner();
            winner.addCards(table.getRoundTrophy());
            this.gameView.displayLine(this.activePlayer.getName() + " is the winner of this round!");
        }

        checkIfWon();
    }

    private void showCard(Card card) {
        // this.gameView.displayCard(card);
        this.gameView.displayLine(card.toString());
    }

    private void showCards() {
        this.gameView.displayTable();
    }

    private void checkIfWon() {
        for (Player player : players) {
            if (player.getNumOfCards() > 0) {
                this.isActive = false;
            }
        }
    }

    private Player findWinningCardOwner() {
        for (Player player : players) {
            if (player.hasCard(table.getWinningCard())) {
                return player;
            }
        }
        return null;
    }
}