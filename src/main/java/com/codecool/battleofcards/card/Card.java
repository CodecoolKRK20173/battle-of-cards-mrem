package com.codecool.battleofcards.card;

public class Card {
    private String name;
    private CardAttribute firstAttribute;
    private CardAttribute secondAttribute;
    private CardAttribute thirdAttribute;
    private CardAttribute fourthAttribute;

    public Card(String name, CardAttribute... cardAttributes) {
        this.name = name;
        this.firstAttribute = cardAttributes[0];
        this.secondAttribute = cardAttributes[1];
        this.thirdAttribute = cardAttributes[2];
        this.fourthAttribute = cardAttributes[3];
    }

    public double getAttributeValue(int attributeNumber) {
        return chooseAttribute(attributeNumber).getValue();
    }

    public String getAttributeLabel(int attributeNumber) {
        return chooseAttribute(attributeNumber).getLabel();
    }

    private CardAttribute chooseAttribute(int attributeNumber) {
        CardAttribute choosedAttribute;
        switch (attributeNumber) {
            case 1:
                choosedAttribute = this.firstAttribute;
                break;
            case 2:
                choosedAttribute = this.secondAttribute;
                break;
            case 3:
                choosedAttribute = this.thirdAttribute;
                break;
            case 4:
                choosedAttribute = this.fourthAttribute;
                break;
            default:
                choosedAttribute = null;
        }

        return choosedAttribute;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s: %.2f\n%s: %.2f\n%s: %.2f\n%s: %.2f", this.name,
                                                                           this.firstAttribute.getLabel(),
                                                                           this.firstAttribute.getValue(),
                                                                           this.secondAttribute.getLabel(),
                                                                           this.secondAttribute.getValue(),
                                                                           this.thirdAttribute.getLabel(),
                                                                           this.thirdAttribute.getValue(),
                                                                           this.fourthAttribute.getLabel(),
                                                                           this.fourthAttribute.getValue());
    }
}