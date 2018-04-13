package com.codecool.battleofcards.card.comparator;

import com.codecool.battleofcards.card.Card;

import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

/**
* This class is a factory for Card comparators.
* <p> @see CardComparator
*/
public class CardComparatorFactory {
    private final Map<Integer, Comparator<Card>> comparators;

    /**
     * CardComparatorFactory constructor
     */
    public CardComparatorFactory() {
        this.comparators = new HashMap<>();
    }

    /**
    * Method creating comparators on the go.
    * <p> Uses flyweight pattern to create new comparators
    * @param attributeNumber number of attribute of Card object.
    * @return comparator from given attributeNumber
    */

    public Comparator<Card> getCardComparator(int attributeNumber) {
        if (!this.comparators.containsKey(attributeNumber)) {
            this.comparators.put(attributeNumber, new CardComparator(attributeNumber));
        }
        return this.comparators.get(attributeNumber);
    }
}
