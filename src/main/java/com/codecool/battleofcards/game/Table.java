package com.codecool.battleofcards.game;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import com.codecool.battleofcards.card.Card;
import com.codecool.battleofcards.card.comparator.*;

public class Table {
    private List<Card> cards;
    private List<Card> cardsAfterDraw;
    private Comparator<Card> cardComparator;

    private boolean isRoundResolved;

    private Card winningCard;

    public Table() {
        this.cards = new ArrayList<>();
        this.cardsAfterDraw = new ArrayList<>();
        // TODO check - compilation error
        //this.cardComparator = new Comparator();
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;

        if (this.isRoundResolved) {
            this.cardsAfterDraw.clear();
        }
    }

    public void setCardComparator(Comparator<Card> cardComparator) {
        this.cardComparator = cardComparator;
    }

    public void resolveRound() {
        this.winningCard = Collections.max(this.cards, this.cardComparator);

        this.isRoundResolved = true;  // Let's assume it is and check this assumption below
        for (Card card : this.cards) {
            if (this.cardComparator.compare(this.winningCard, card) == 0 && this.winningCard != card) {
                this.isRoundResolved = false;
                this.cardsAfterDraw = this.cards;
                break;
            }
        }
    }

    public Card getWinningCard() {
        if (this.isRoundResolved) {
            return this.winningCard;
        }
        // TODO check - compilation error
        return null;
    }

    public List<Card> getRoundTrophy() {
        // TODO check - compilation error
        this.cards.addAll(this.cardsAfterDraw);
        return this.cards;
    }
}