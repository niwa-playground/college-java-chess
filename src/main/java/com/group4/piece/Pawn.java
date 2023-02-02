package com.group4.piece;

import com.group4.Board;
import com.group4.Piece;
import com.group4.Spot;

public class Pawn extends Piece {
    private boolean enPassant = false;

    public Pawn(boolean white) {
        super(white);
    }

    public boolean getEnPassant() {
        return this.enPassant;
    }

    public void setEnPassant(boolean bool) {
        this.enPassant = bool;
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece() != null) {
            if (end.getPiece().isWhite() == super.white) {
                return false;
            }
        }
        int x = end.getX() - start.getX();
        int y = end.getY() - start.getY();

        if (super.white) {
            // White
            if (end.getPiece() != null) {
                if (Math.abs(x) + y == 2) {
                    return true;
                }
            }

            if (y < 0 || y > 2) {
                return false;
            } else if (this.getEnPassant() && y == 2) {
                return false;
            }

            if (y == 2) {
                this.setEnPassant(true);
                return true;
            }

            return x + y == 1;
        }else {
            // Black
            if (end.getPiece() != null) {
                if (Math.abs(x) - y == 2) {
                    return true;
                }
            }
            if (y > 0 || y < -2) {
                return false;
            } else if (this.getEnPassant() && y == -2) {
                return false;
            }
            if (y == -2) {
                this.setEnPassant(true);
                return true;
            }
            return x + y == -1;
        }
    }
}
