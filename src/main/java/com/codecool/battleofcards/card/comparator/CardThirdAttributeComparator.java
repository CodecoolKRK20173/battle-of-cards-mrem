package com.codecool.battleofcards.card.comparator;

import com.codecool.battleofcards.card.Card;
import java.util.Comparator;

public class CardThirdAttributeComparator implements Comparator<Card> {
    @Override
    public int compare(Card card, Card otherCard) {
        if (card.getAttributeValue(3) > otherCard.getAttributeValue(3)) {
            return 1;
        } else if (card.getAttributeValue(3) < otherCard.getAttributeValue(3)) {
            return -1;
        } else {
            return 0;
        }
    }
}