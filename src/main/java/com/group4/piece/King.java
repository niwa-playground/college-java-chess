package com.group4.piece;

import com.group4.Board;
import com.group4.Piece;
import com.group4.Spot;

public class King extends Piece {
    private boolean castlingDone = false;

    public King(boolean white) {
        super(white);
    }

    public boolean isCastlingDone() {
        return this.castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece() != null) {
            if (end.getPiece().isWhite() == super.white) {
                return false;
            }
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1 || (x == 1 && y == 1)) {
            return true;
        }
        if (x == 2 && y == 0) {
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
            }
            return this.isValidCastling(board, start, end);
        }
        return false;
    }

    private boolean isValidCastling(Board board, Spot start, Spot end) {
        if (this.isCastlingDone()) {
            return false;
        }
        if (start.getPiece().isWhite()) {
            if (!(board.getBox(4, 0).getPiece() instanceof King)) {
                return false;
            }
        } else {
            if (!(board.getBox(4, 7).getPiece() instanceof King)) {
                return false;
            }
        }
        int x = end.getX() - start.getX();
        // Left or Right
        if (x > 0) {
            if (start.getPiece().isWhite()) {
                if (board.getBox(7, 0).getPiece() != null && board.getBox(7, 0).getPiece() instanceof Rook) {
                    // Right
                    board.getBox(5, 0).setPiece(board.getBox(7, 0).getPiece());
                    board.getBox(7, 0).setPiece(null);
                }
            } else {
                if (board.getBox(7, 7).getPiece() != null && board.getBox(7, 7).getPiece() instanceof Rook) {
                    // Right
                    board.getBox(5, 7).setPiece(board.getBox(7, 7).getPiece());
                    board.getBox(7, 0).setPiece(null);
                }
            }
        } else if (x < 0) {
            if (start.getPiece().isWhite()) {
                if (board.getBox(0, 0).getPiece() != null && board.getBox(0, 0).getPiece() instanceof Rook) {
                    // Left
                    board.getBox(3, 0).setPiece(board.getBox(0, 0).getPiece());
                    board.getBox(0, 0).setPiece(null);
                }
            } else {
                if (board.getBox(0, 7).getPiece() != null && board.getBox(0, 7).getPiece() instanceof Rook) {
                    // Left
                    board.getBox(3, 7).setPiece(board.getBox(0, 7).getPiece());
                    board.getBox(0, 0).setPiece(null);
                }
            }
        }
        return true;
    }

    public boolean castlingMove(Spot start, Spot end) {
        start.setPiece(null);
        end.setPiece(this);
        this.setCastlingDone(true);
        return true;
    }
}