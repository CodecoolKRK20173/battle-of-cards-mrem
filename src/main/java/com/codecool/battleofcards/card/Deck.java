package com.codecool.battleofcards.card;

import java.util.*;
import java.io.*;

public class Deck implements Shuffleable{

    private List<Card> cards;
    private String fileContent = readerFromFile();

    public Deck(String fileContent){
        this.fileContent = fileContent;
        createCards(fileContent);
    }

    private void createCards(String fileContent){
        String[] listStatistics = fileContent.split("\n");
     
        for (String line : listStatistics){
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

                CardAttributes[] attributes = {firstAttribute, secondAttribute, thirdAttribute, fourthAttribute};

                this.cards.add(new Card(name, attributes));
            }
        }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public List<Pile> deal(int num){
        List<Pile> piles = new ArrayList<>();

        int start = 0;
        int numPlayer = this.cards.size() / num;

        for(int i = 0; i<num; i++){
            piles.add(new Pile(this.cards.sublist(start,numPlayer)));
            start = numPlayer;
            numPlayer += start;
        }
        return piles;
    }
    
    public String readerFromFile() {
        String content = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("statistics.csv"));
            String line = reader.readLine();

            while(line != null){
                content += line + "\n";
                line = reader.readLine();      
            }
                reader.close();
        } catch (IOException e) {
            System.err.println("There is no such file");
            System.exit(0);
        }    
        return content.toLowerCase();
    }


}