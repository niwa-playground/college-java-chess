package com.group4.player;

import com.group4.Player;

public class HumanPlayer extends Player {
    public static final boolean human = true;

    public HumanPlayer(boolean white) {
        super(white);
    }

    @Override
    public boolean isHumanPlayer() {
        return human;
    }
}
