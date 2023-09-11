package com.chess;

import com.chess.model.board.Board;
import com.chess.model.pieces.AbstractPiece;

public class Main{
    public static void main(String[] args) {
        Board board = new Board();
        AbstractPiece[][] pieceArray = board.getBoard();
        for (AbstractPiece[] abstractPieceRow : pieceArray){
            for (AbstractPiece abstractPiece : abstractPieceRow)
            System.out.println(abstractPiece.getClass());
        }
    }
}