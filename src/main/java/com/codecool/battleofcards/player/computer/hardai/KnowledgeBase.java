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
