package com.codecool.battleofcards.player.computer.hardai;
public class KnowledgeBase{

    private static CardComparatorFactory comparatorFactory;
    private static Map<Card, CardStrenghts> cardsStrenghts;
    private int deckSize =34;
    private static final int CARD_STATS_NUM = 4;
    private static final String FILESOURCE = "statistics.csv";

    public KnowledgeBase(){
        //due to specification restrictions about static methods
        if(cardsStrenghts == null){
            initializeBase(); // ... we want to be sure we will not run this more than once
        }
    }

    public int getBestAttributeOfCard(Card card){
        return cardsStrenghts.get(card).getBestAttributeNumber();
    }

    private void initializeBase(){
        comparatorFactory = new CardComparatorFactory();
        cardsStrenghts = new HashMap<Card, CardStrenghts>();
        List<Card> allCards = createCards();

        for(Card card : allCards)
            cardsStrenghts.put(card, new CardStrenghts());

        deckSize = allCards.size();
        initializeCardsStrenghts(allCards);

        for (int i = 1; i <= CARD_STATS_NUM; i++)
            generateAttributeStrenghts(i, allCards);

    }


    private void initializeCardsStrenghts(List<Card> cards){

        for(Card card : cards)
            cardsStrenghts.put(card, new CardStrenghts());
    //    deckSize = cards.size();

    }

    private void generateAttributeStrenghts(int attributeNumber, List<Card> cards){

        Collections.sort(cards, comparatorFactory.getCardComparator(attributeNumber));

        for(int i = 0; i < cards.size(); i++){
            cardsStrenghts.get(cards.get(i)).setAttribute(attributeNumber, (i));
        }
    }

    private double calculatePercentage(int chunk, int size){
        return ((size - (chunk+1)) * 100) / size;
    }
