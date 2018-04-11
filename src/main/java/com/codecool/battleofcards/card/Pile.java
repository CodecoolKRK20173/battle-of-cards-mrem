package com.codecool.battleofcards.card;

import java.util.LinkedList;
import java.util.List;

public class Pile implements Comparable<Pile> {
    private LinkedList<Card> cards;
    
    Pile(List<Card> cards) {
        this.cards = new LinkedList<Card>(cards);
    }

    public int getCardsNumber() {
        return this.cards.size();
    }

    public void addCards(List<Card> trophy) {
       cards.addAll(trophy);
    }

    public Card peekTopCard() {
        return cards.peek();
    }

    public Card getTopCard() {
        return cards.poll();
    }
    @Override
    public int compareTo(Pile pile) {
        if(this.getCardsNumber() == pile.getCardsNumber()) {
            return 0;
        } else if(this.getCardsNumber() < pile.getCardsNumber()) {
            return -1;
        }
        return 1;
    }
}
