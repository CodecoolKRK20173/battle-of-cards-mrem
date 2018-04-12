package com.codecool.battleofcards.display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.codecool.battleofcards.card.Card;
import com.codecool.battleofcards.player.*;

public class GameView {
    public void displayLine(String lineContent) {
        System.out.println(lineContent);
    }

    public void displayBlock(StringBuilder block) {
        System.out.println(block.toString());
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

        displayBlock(cardToPrint);
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

        displayBlock(table);
    }

    public void displayHeader(List<Player> players) {
        StringBuilder names = new StringBuilder();
        names.append("  ");
        for(Player player : players) {
            names.append(centeredString(player.getName()+ " - Cards left: " + player.getNumOfCards()) + " ");          
        }
        displayBlock(names);
        displayEmptyLine();
    }

    public void displayPlayerDecision(Player player, String attributeLabel) {
        String playerDecision = String.format("%s choosed %s", player.getName(),
                                                               attributeLabel.toLowerCase());
        displayLine(playerDecision);
    }

    public String centeredString(String text) {
        int widthColumn = 35;
        int padSize = widthColumn - text.length();
        int padStart = text.length() + padSize / 2;
        text = String.format("%" + padStart + "s", text);
        text = String.format("%-" + widthColumn  + "s", text);

        return text;
    }

    public String readerFromFile(String filename) {
        StringBuilder fileContent = new StringBuilder();

        ClassLoader classLoader = getClass().getClassLoader();
        Path filePath = Paths.get(classLoader.getResource(filename).getFile());

        try (Scanner reader = new Scanner(filePath)) {
            while (reader.hasNextLine()) {
                fileContent.append(reader.nextLine());
                fileContent.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }

    public void waitForAction() {
        displayInputPrompt("Press enter to continue");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
    }

    public void displayFirstScreen() {
        clearScreen();
        displayLine(readerFromFile("start_screen.txt"));
        waitForAction();
    }


}