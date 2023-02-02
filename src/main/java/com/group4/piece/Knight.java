package com.group4.piece;

import com.group4.Board;
import com.group4.Piece;
import com.group4.Spot;

public class Knight extends Piece {
    public Knight(boolean white){
        super(white);
    }
    @Override
    public boolean canMove(Board board, Spot start, Spot end){
        if(end.getPiece() != null){
            if (end.getPiece().isWhite() == super.white) {
                return false;
            }
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x*y == 2;
    }
}
