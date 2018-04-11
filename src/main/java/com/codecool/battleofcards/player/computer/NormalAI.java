package com.codecool.battleofcards.player.computer;

import com.codecool.battleofcards.card.Pile;
import java.util.Random;

public class NormalAI extends ComputerPlayer{

    private static Random generator = new Random();
    private static final int CARD_STATS_NUM = 4;

    public NormalAI(Pile cards){

        String name = chooseName();
        NormalAI(name, cards);

    }

    private NormalAI(String name, Pile cards){

        super(name, cards);

    }

    @Override
    public int getChoice(){

        return generator.nextInt(CARD_STATS_NUM) + 1;

    }

}
