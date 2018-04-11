package com.codecool.battleofcards.card.comparator;

import com.codecool.battleofcards.card.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CardComparatorFactory {
    List<Comparator<Card>> comparators = new ArrayList<>();

    public CardComparatorFactory() {
        this.comparators.add(new CardFirstAttributeComparator());
        this.comparators.add(new CardSecondAttributeComparator());
        this.comparators.add(new CardThirdAttributeComparator());
        this.comparators.add(new CardFourthAttributeComparator());
    }

    public Comparator<Card> getCardComparator(int attributeNumber) {
        return this.comparators.get(attributeNumber - 1);
    }
}
