package com.group4.piece;

import com.group4.Board;
import com.group4.Piece;
import com.group4.Spot;

public class Queen extends Piece {
    public Queen(boolean white){
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
        if(x > 1 || y > 1){
            // Bishop
            if (end.getX() - start.getX() > 1 && end.getY() - start.getY() > 1) {
                // Right-Top
                for (int i = start.getX() + 1; i < end.getX(); i++) {
                    if (board.getBox(i, i).getPiece() != null) {
                        return false;
                    }
                }
            } else if (end.getX() - start.getX() < -1 && end.getY() - start.getY() > 1) {
                // Left-Top
                for (int i = start.getX() - 1; i > end.getX(); i--) {
                    if (board.getBox(i, i).getPiece() != null) {
                        return false;
                    }
                }
            } else if (end.getY() - start.getY() < -1 && end.getY() - start.getY() < -1) {
                // Left-Bottom
                for (int i = start.getY() - 1; i > end.getY(); i--) {
                    if (board.getBox(i, i).getPiece() != null) {
                        return false;
                    }
                }
            } else if (end.getY() - start.getY() > 1 && end.getY() - start.getY() < -1) {
                // Right-Bottom
                for (int i = start.getY() + 1; i < end.getY(); i++) {
                    if (board.getBox(i, i).getPiece() != null) {
                        return false;
                    }
                }
            }
            // Rook
            if (end.getX() - start.getX() > 1 && y == 0) {
                // Right
                for (int i = start.getX() + 1; i < end.getX(); i++) {
                    if (board.getBox(i, start.getY()).getPiece() != null) {
                        return false;
                    }
                }
            } else if (end.getX() - start.getX() < -1 && y == 0) {
                // Left
                for (int i = start.getX() - 1; i > end.getX(); i--) {
                    if (board.getBox(i, start.getY()).getPiece() != null) {
                        return false;
                    }
                }
            } else if (end.getY() - start.getY() < -1 && x == 0) {
                // Bottom
                for (int i = start.getY() - 1; i > end.getY(); i--) {
                    if (board.getBox(start.getX(), i).getPiece() != null) {
                        return false;
                    }
                }
            } else if (end.getY() - start.getY() > 1 && x == 0) {
                // Top
                for (int i = start.getY() + 1; i < end.getY(); i++) {
                    if (board.getBox(start.getX(), i).getPiece() != null) {
                        return false;
                    }
                }
            }

            if (x == 0 || y == 0) {
                return true;
            }

            if (x == y) {
                return true;
            }
        }
        return x+y == 1 || x+y == 2;
    }
}
