package com.group4;

import com.group4.Interface.White;

public abstract class Player implements White {
    private boolean white;

    public Player(boolean white) {
        this.white = white;
    }

    @Override
    public boolean isWhite() {
        return this.white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public abstract boolean isHumanPlayer();
}
