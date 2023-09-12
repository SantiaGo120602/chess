package com.chess;

import java.util.ArrayList;

import com.chess.model.actions.Move;
import com.chess.model.board.Board;

public class Main{
    public static void main(String[] args) {
        Board board = new Board();
        ArrayList<Move> pieceList = board.getValidMoves(2, 1);
        for (Move move : pieceList){
            System.out.println(move.getMove()[1]);
        }
    }
}