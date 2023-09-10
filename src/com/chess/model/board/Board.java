package com.chess.model.board;

import java.util.ArrayList;

import com.chess.model.pieces.AbstractPiece;
import com.chess.model.pieces.Bishop;
import com.chess.model.pieces.EmptyPiece;
import com.chess.model.pieces.King;
import com.chess.model.pieces.Knight;
import com.chess.model.pieces.Pawn;
import com.chess.model.pieces.Queen;
import com.chess.model.pieces.Rook;
import com.chess.model.pieces.Team;

public class Board {
    private AbstractPiece[][] board;
    
    public Board(){
        this.board = createStandardBoard();
    }

    public Board(AbstractPiece[][] board){
        this.board = board;
    }

    private AbstractPiece[][] createStandardBoard(){
        AbstractPiece[][] standardBoard = new AbstractPiece[8][8];

        for (int i = 0; i < standardBoard.length; i++){
            for (int j = 2; j < 6; j++){
                standardBoard[j][i] = new EmptyPiece();    
            }
            standardBoard[1][i] = new Pawn(Team.WHITE);
            standardBoard[6][i] = new Pawn(Team.BLACK);
        }

        standardBoard[0][0] = new Rook(Team.WHITE);
        standardBoard[0][7] = new Rook(Team.WHITE);
        standardBoard[7][0] = new Rook(Team.BLACK);
        standardBoard[7][7] = new Rook(Team.BLACK);

        standardBoard[0][1] = new Knight(Team.WHITE);
        standardBoard[0][6] = new Knight(Team.WHITE);
        standardBoard[7][1] = new Knight(Team.BLACK);
        standardBoard[7][6] = new Knight(Team.BLACK);

        standardBoard[0][2] = new Bishop(Team.WHITE);
        standardBoard[0][5] = new Bishop(Team.WHITE);
        standardBoard[7][2] = new Bishop(Team.BLACK);
        standardBoard[7][5] = new Bishop(Team.BLACK);

        standardBoard[0][3] = new Queen(Team.WHITE);
        standardBoard[0][4] = new King(Team.WHITE);
        standardBoard[7][3] = new Queen(Team.BLACK);
        standardBoard[7][4] = new King(Team.BLACK);

        return standardBoard;
    }

    public void move(Integer[] start, Integer[] end){
        if (start.length != 2 || end.length != 2) {
            throw new IllegalArgumentException("Not a valid move");
        }

        board[end[0]][end[1]] = board[start[0]][start[1]];
        board[start[0]][start[1]] = new EmptyPiece();
    }

    public ArrayList<Integer[]> listMoves(Integer[] coordinates){
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Not a valid coordinate");
        }

        AbstractPiece piece = board[coordinates[0]][coordinates[1]];
        ArrayList<Integer[]> validMoves = new ArrayList<>();

        if (piece instanceof EmptyPiece){
            Integer[] movement = {-1, -1};
            validMoves.add(movement);
        }

        else if (piece instanceof Pawn){
            
        }

    }
}
