package com.codecool.battleofcards.player;

import com.codecool.battleofcards.card.Card;
import com.codecool.battleofcards.card.Pile;

import java.util.List;

public abstract class Player {
    private String name;
    private Pile cards;

    public Player(String name, Pile cards) {
        this.name = name;
        this.cards = cards;
    }

    public abstract int getChoice();

    public String getName() {
        return this.name;
    }

    public Pile getCards() {
        return this.cards;
    }


    public int getNumOfCards() {
        return this.cards.getCardsNumber();
    }

    public boolean hasCard(Card card) {
        return this.cards.containsCard(card);
    }

    public void addCards(List<Card> trophyCards) {
        this.cards.addCards(trophyCards);
    }

    @Override
    public String toString() {
        return this.name;
    }
}