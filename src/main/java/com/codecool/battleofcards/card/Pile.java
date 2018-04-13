package com.codecool.battleofcards.card;

import java.lang.Comparable;

import java.util.LinkedList;
import java.util.List;

/**
* This class represents pile of Cards owned by each Player
*/

public class Pile implements Comparable<Pile> {
    private LinkedList<Card> cards;

    public Pile(List<Card> cards) {
        this.cards = new LinkedList<>(cards);
    }

    /**
     * @return how many cards are in Pile
     */
    public int getCardsNumber() {
        return this.cards.size();
    }

    /**
     * @param newCards Card to be added into cards
     */
    public void addCards(List<Card> newCards) {
       cards.addAll(newCards);
    }

    /**
     * @return top Card object from cards
     */
    public Card peekTopCard() {
        return cards.peek();
    }

    /**
     * retrive and remove top Card object from cards
     * @return Card object
     */
    public Card getTopCard() {
        return cards.poll();
    }

    /**
     * checks if this Pile cards contains given Card
     * @param  card
     * @return boolean
     */
    public boolean containsCard(Card card) {
        return this.cards.contains(card);
    }

    /**
     * overriten method for comparing piles depending on size of cards
     * @param  other other Pile object
     * @return      1, -1 or 0
     */
    @Override
    public int compareTo(Pile other) {
        if(this.getCardsNumber() == other.getCardsNumber()) {
            return 0;
        } else if(this.getCardsNumber() < other.getCardsNumber()) {
            return -1;
        }
        return 1;
    }
}
