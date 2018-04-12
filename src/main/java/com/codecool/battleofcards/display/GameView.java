package com.codecool.battleofcards.display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.codecool.battleofcards.card.Card;
import com.codecool.battleofcards.player.*;

public class GameView {
    public void displayLine(String lineContent) {
        System.out.println(lineContent);
    }

    public void displayEmptyLine() {
        System.out.println();
    }

    public void displayEmptyLines(int numberOfEmptyLines) {
        for (int i = 0; i < numberOfEmptyLines; i++) {
            displayEmptyLine();
        }
    }

    public void displayInputPrompt(String inputPrompt) {
        System.out.print(inputPrompt + ": ");
    }

    public void displayInline(String text) {
        System.out.print(text);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void displayCard(Card card) {
        StringBuilder cardToPrint = new StringBuilder();
        String[] cardSplitted = card.toString().split("\n");

        for (int i = 0; i < 5; i++) {
            if (i != 0) {
                cardToPrint.append(i);
            } else {
                cardToPrint.append(" ");
            }
            cardToPrint.append("|");
            cardToPrint.append(centeredString(cardSplitted[i]));
            cardToPrint.append("|");
            cardToPrint.append("\n");
        }

        System.out.println(cardToPrint.toString());
    }

    public void displayTable(List<Card> cards) {
        List<List<String>> allCardsSplitted = new ArrayList<>();
        for (Card card : cards) {
            List<String> cardSplitted = Arrays.asList(card.toString().split("\n"));
            allCardsSplitted.add(cardSplitted);
        }

        StringBuilder table = new StringBuilder();
        for (int i = 0; i <= 4; i++) {
            if (i != 0) {
                table.append(i);
            } else {
                table.append(" ");
            }

            table.append("|");
            for (List<String> card : allCardsSplitted) {
                table.append(centeredString(card.get(i)));
                table.append("|");
            }
            table.append("\n");
        }

        System.out.println(table.toString());
    }

    public void displayPlayersName(List<Player> players) {
        StringBuilder names = new StringBuilder();
        names.append("  ");
        for(Player player : players) {
            names.append(centeredString(player.getName()+ " - Cards left: " + player.getNumOfCards()) + " ");          
        }
        System.out.println(names);
        System.out.println();
    }

    public String centeredString(String text) {
        int widthColumn = 35;
        int padSize = widthColumn - text.length();
        int padStart = text.length() + padSize / 2;
        text = String.format("%" + padStart + "s", text);
        text = String.format("%-" + widthColumn  + "s", text);

        return text;
    }
}