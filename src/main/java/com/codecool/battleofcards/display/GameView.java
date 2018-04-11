package com.codecool.battleofcards.display;


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

    public void displayTable() {
        // TODO
    }

    public void displayGameEnd() {
        // TODO
    }
}