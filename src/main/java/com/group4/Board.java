package com.group4;

import com.group4.piece.*;

public class Board {

  private Spot[][] boxes = new Spot[8][8];

  public Board() {
    this.resetBoard();
  }

  public Board(Spot[][] boxes) {
    this.setBox(boxes);
  }

  public void setBox(Spot[][] boxes) {
    this.boxes = boxes;
  }

  public Spot getBox(int x, int y) {
    if (x < 0 || x > 7 || y < 0 || y > 7) {
      return null;
    }
    return boxes[y][x];
  }

  public Spot getBox(Spot spot) {
    int x = spot.getX();
    int y = spot.getY();
    if (x < 0 || x > 7 || y < 0 || y > 7) {
      return null;
    }
    return boxes[y][x];
  }

  public void printBoard() {
    boolean counter = true;
    String temp = "";
    for (int i = 7; i >= -1; i--) {
      for (int j = -1; j <= 7; j++) {
        if (i == -1) {
          if (j >= 0) {
            // X
            System.out.printf("[%d\u2000]", j);
          } else {
            System.out.print("[  ]");
          }
        } else {
          if (j == -1) {
            // Y
            System.out.printf("[%d ]", i);
          }
        }
        if (counter) {
          if (i - 1 == -1) {
            if (j == 7) {
              counter = false;
            }
          }
          if (j >= 0) {
            if (boxes[i][j].getPiece() == null) {
              temp = "\u2001";
            }
            if (boxes[i][j].getPiece() instanceof Pawn) {
              if (boxes[i][j].getPiece().isWhite()) {
                temp = "\u2659";
              } else {
                temp = "\u265F";
              }
            } else if (boxes[i][j].getPiece() instanceof Rook) {
              if (boxes[i][j].getPiece().isWhite()) {
                temp = "\u2656";
              } else {
                temp = "\u265C";
              }
            } else if (boxes[i][j].getPiece() instanceof Knight) {
              if (boxes[i][j].getPiece().isWhite()) {
                temp = "\u2658";
              } else {
                temp = "\u265E";
              }
            } else if (boxes[i][j].getPiece() instanceof Bishop) {
              if (boxes[i][j].getPiece().isWhite()) {
                temp = "\u2657";
              } else {
                temp = "\u265D";
              }
            } else if (boxes[i][j].getPiece() instanceof Queen) {
              if (boxes[i][j].getPiece().isWhite()) {
                temp = "\u2655";
              } else {
                temp = "\u265B";
              }
            } else if (boxes[i][j].getPiece() instanceof King) {
              if (boxes[i][j].getPiece().isWhite()) {
                temp = "\u2654";
              } else {
                temp = "\u265A";
              }
            }
            System.out.printf("[%s]", temp);
          }
        }
      }
      System.out.println();
    }
  }

  public void resetBoard() {
    // White Piece
    boxes[0][0] = new Spot(0, 0, new Rook(true));
    boxes[0][1] = new Spot(1, 0, new Knight(true));
    boxes[0][2] = new Spot(2, 0, new Bishop(true));
    boxes[0][3] = new Spot(3, 0, new Queen(true));
    boxes[0][4] = new Spot(4, 0, new King(true));
    boxes[0][5] = new Spot(5, 0, new Bishop(true));
    boxes[0][6] = new Spot(6, 0, new Knight(true));
    boxes[0][7] = new Spot(7, 0, new Rook(true));
    for (int j = 0; j < 8; j++) {
      boxes[1][j] = new Spot(j, 1, new Pawn(true));
    }
    // Black Piece
    boxes[7][0] = new Spot(0, 7, new Rook(false));
    boxes[7][1] = new Spot(1, 7, new Knight(false));
    boxes[7][2] = new Spot(2, 7, new Bishop(false));
    boxes[7][3] = new Spot(3, 7, new Queen(false));
    boxes[7][4] = new Spot(4, 7, new King(false));
    boxes[7][5] = new Spot(5, 7, new Bishop(false));
    boxes[7][6] = new Spot(6, 7, new Knight(false));
    boxes[7][7] = new Spot(7, 7, new Rook(false));
    for (int j = 0; j < 8; j++) {
      boxes[6][j] = new Spot(j, 6, new Pawn(false));
    }
    // Null
    for (int i = 2; i <= 5; i++) {
      for (int j = 0; j < 8; j++) {
        boxes[i][j] = new Spot(j, i, null);
      }
    }
  }
}
