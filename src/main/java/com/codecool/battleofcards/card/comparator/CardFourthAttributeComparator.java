package com.codecool.battleofcards.card.comparator;

import com.codecool.battleofcards.card.Card;
import java.util.Comparator;

public class CardFourthAttributeComparator implements Comparator<Card> {
    @Override
    public int compare(Card card, Card otherCard) {
        if (card.getAttributeValue(4) > otherCard.getAttributeValue(4)) {
            return 1;
        } else if (card.getAttributeValue(4) < otherCard.getAttributeValue(4)) {
            return -1;
        } else {
            return 0;
        }
    }
}