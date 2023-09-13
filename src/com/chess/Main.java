package com.chess;


import com.chess.model.board.Board;
import com.chess.model.pieces.AbstractPiece;

public class Main{
    public static void main(String[] args) {
        Board board = new Board();
        AbstractPiece abstractPiece = board.getBoard()[0][6];
        System.out.println(abstractPiece.getPath());
    }
}