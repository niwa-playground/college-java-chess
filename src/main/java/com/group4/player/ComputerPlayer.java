package com.group4.player;

import com.group4.Player;

public class ComputerPlayer extends Player {
    public static final boolean human = false;

    public ComputerPlayer(boolean white) {
        super(white);
    }

    @Override
    public boolean isHumanPlayer() {
        return human;
    }

}
