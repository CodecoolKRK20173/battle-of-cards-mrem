package com.codecool.battleofcards.display;

import com.codecool.battleofcards.player.Player;

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
        inputPrompt += ": ";
        System.out.print(inputPrompt);
    }

    public void displayInline(String text) {
        System.out.print(text);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void displayMenu() {
        // TODO
    }

    public void displayTable(List<Player> players) {
        int widthColumn = 50;

        for (Player player : players) {
            System.out.print(centeredString(player.getName()) + " | ");
        }

        System.out.println("");
        for (Player player : players) {
            System.out.print(centeredString(String.valueOf(player.getNumOfCards()))+ " | ");
        }

        System.out.println("");

        for (Player player : players) {
            String[] printCard = player.getCards().peekTopCard().toString().split("\n");
            for (String card : printCard) {
                System.out.print(centeredString(card + " | ");
            }
        }
        System.out.println("");
        
    }

    public String centeredString(String text){

        int widthColumn = 50;
        int padSize = widthColumn - text.length();
        int padStart = text.length() + padSize / 2;
        text = String.format("%" + padStart + "s", text);
        text = String.format("%-" + widthColumn  + "s", text);
        
        return text;
    }

    public void displayGameEnd() {
        // TODO
    }
}