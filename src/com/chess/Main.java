package com.chess;

import com.chess.model.board.Board;

public class Main{
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.getBoard());
    }
}