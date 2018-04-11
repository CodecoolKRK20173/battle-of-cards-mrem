package com.codecool.battleofcards.player.computer;

import com.codecool.battleofcards.card.Pile;

public class NormalAI extends ComputerPlayer{

    public NormalAI(Pile cards){

        String name = chooseName();
        NormalAI(name, cards);

    }

    private NormalAI(String name, Pile cards){

        super(name, cards);

    }

}
