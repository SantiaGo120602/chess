package com.chess.model.board;

import com.chess.model.pieces.Pawn;
import com.chess.model.pieces.Team;

public class Board {
    private Tile[][] board;
    
    public Board(){
        this.board = createStandardBoard();
    }

    public Board(Tile[][] board){
        this.board = board;
    }

    private Tile[][] createStandardBoard(){
        Tile[][] standardBoard = new Tile[8][8];
        for (int i = 0; i < standardBoard.length; i++){
            standardBoard[i][1] = new Tile(File(String.valueOf((char) 97+i)), Rank.ONE, new Pawn(Team.WHITE));
        }
    }
}
