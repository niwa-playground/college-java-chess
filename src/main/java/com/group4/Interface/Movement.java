package com.group4.Interface;

import com.group4.Board;
import com.group4.Spot;

public interface Movement {
    boolean canMove(Board board, Spot start, Spot end);
}
