package com.group4;

import com.group4.piece.King;

public class Game {
    private final Player[] player = new Player[2];
    private final Board board;
    private Player currentTurn;
    private GameStatus status;

    public Game(Board board, Player p1, Player p2) {
        this.board = board;
        player[0] = p1;
        player[1] = p2;
        this.board.resetBoard();
        if (p1.isWhite()) {
            this.setCurrentTurn(p1);
        } else {
            this.setCurrentTurn(p2);
        }
    }

    public Game(Player p1, Player p2) {
        this.board = new Board();
        player[0] = p1;
        player[1] = p2;
        if (p1.isWhite()) {
            this.setCurrentTurn(p1);
        } else {
            this.setCurrentTurn(p2);
        }
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player player) {
        this.currentTurn = player;
    }

    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean playerMove(Player player, Spot start, Spot end) {
        if (start.getPiece() == null) {
            return false;
        }

        if (player != this.currentTurn) {
            return false;
        }

        if (start.getPiece().isWhite() != player.isWhite()) {
            return false;
        }

        King kingKilled = null;
        if (end.getPiece() instanceof King) {
            kingKilled = (King) end.getPiece();
        }

        // Makan bidak
        if (end.getPiece() != null) {
            end.getPiece().setKilled(true);
        }

        if (start.getPiece() != null && !(start.getPiece() instanceof King)) {
            end.setPiece(start.getPiece());
            start.setPiece(null);
        } else {
            ((King) start.getPiece()).castlingMove(start, end);
        }

        if (kingKilled != null) {
            if (player.isWhite()) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        // Ganti Giliran
        if (this.currentTurn == this.player[0]) {
            this.currentTurn = this.player[1];
        } else {
            this.currentTurn = this.player[0];
        }

        return true;
    }
}
