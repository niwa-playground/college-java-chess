package com.group4;

import com.group4.Interface.Movement;
import com.group4.Interface.White;

public abstract class Piece implements White, Movement {
    protected boolean killed = false;
    protected boolean white = false;

    public Piece(boolean white) {
        this.setWhite(white);
    }

    @Override
    public boolean isWhite() {
        return this.white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    @Override
    public abstract boolean canMove(Board board, Spot start, Spot end);
}
