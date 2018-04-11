package com.codecool.battleofcards.player.computer;

import com.codecool.battleofcards.card.Pile;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NormalAI extends ComputerPlayer{

    private static List<String> normalAINames = new ArrayList(Arrays.asList("Average Joe",
                            "No BrAIn",
                            "John Doe"));

    private static Random generator = new Random();
    private static final int CARD_STATS_NUM = 4;


    public NormalAI(Pile cards){

        super(normalAINames.remove(0), cards);

    }


    @Override
    public int getChoice(){

        return generator.nextInt(CARD_STATS_NUM) + 1;

    }


}
