package com.codecool.battleofcards.card;

import java.util.*;
import java.io.*;

public class Deck implements Shuffleable{

    private List<Card> cards;

    public Deck(String filename){
        createCards(filename);
    }

    private void createCards(String filename){
        String[] statisticsList = readerFromFile(filename).split("\n");
        
        for (String line : statisticsList){
            String[] cardStatistic = line.split(",");
                
                String name = cardStatistic[0];

                double firstValue = Double.valueOf(cardStatistic[1]);
                CardAttribute firstAttribute = new CardAttribute("Population density (person per km)", firstValue);

                double secondValue = Double.valueOf(cardStatistic[2]);
                CardAttribute secondAttribute = new CardAttribute("Population size", secondValue);
                
                double thirdValue = Double.valueOf(cardStatistic[3]);
                CardAttribute thirdAttribute = new CardAttribute("GDP (EU)", thirdValue);

                double fourthValue = Double.valueOf(cardStatistic[4]);
                CardAttribute fourthAttribute = new CardAttribute("Area (square km)", fourthValue);

                this.cards.add(new Card(name,
                                        firstAttribute,
                                        secondAttribute,
                                        thirdAttribute,
                                        fourthAttribute));
            }
        }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public List<Pile> deal(int numOfPlayers) {
        List<Pile> piles = new ArrayList<Pile>();

        int playerPileSize = this.cards.size() / numOfPlayers;
        int nextPileStartPos = 0;
        int nextPileEndPos = playerPileSize;
        
        for (int i = 0; i < numOfPlayers; i++) {
            piles.add(new Pile(this.cards.subList(nextPileStartPos, nextPileEndPos)));
            nextPileStartPos += playerPileSize;
            nextPileEndPos += playerPileSize;
        }

        return piles;
    }
    
    public String readerFromFile(String filename) {
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while (line != null) {
                fileContent.append(line);
                fileContent.append("\n");

                line = reader.readLine();      
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }
}