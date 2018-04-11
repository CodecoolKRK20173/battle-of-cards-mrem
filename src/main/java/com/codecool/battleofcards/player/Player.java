package com.codecool.battleofcards.player;

import com.codecool.battleofcards.card.Pile;

public abstract class Player {
    private String name;
    private Pile cards;

    public Player(String name, Pile cards) {
        this.name = name;
        this.cards = cards;
    }

    abstract int getChoice();

    public String getName() {
        return this.name;
    }

    public int getNumOfCards() {
        return this.cards.getCardsNumber();
    }

    @Override
    public String toString() {
        return this.name;
    }
}