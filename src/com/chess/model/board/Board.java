package com.chess.model.board;

import java.util.ArrayList;

import com.chess.model.actions.Move;
import com.chess.model.actions.MoveType;
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
                standardBoard[i][j] = new EmptyPiece();    
            }
            standardBoard[i][1] = new Pawn(Team.WHITE);
            standardBoard[i][6] = new Pawn(Team.BLACK);
        }

        standardBoard[0][0] = new Rook(Team.WHITE);
        standardBoard[7][0] = new Rook(Team.WHITE);
        standardBoard[0][7] = new Rook(Team.BLACK);
        standardBoard[7][7] = new Rook(Team.BLACK);

        standardBoard[1][0] = new Knight(Team.WHITE);
        standardBoard[6][0] = new Knight(Team.WHITE);
        standardBoard[1][7] = new Knight(Team.BLACK);
        standardBoard[6][7] = new Knight(Team.BLACK);

        standardBoard[2][0] = new Bishop(Team.WHITE);
        standardBoard[5][0] = new Bishop(Team.WHITE);
        standardBoard[2][7] = new Bishop(Team.BLACK);
        standardBoard[5][7] = new Bishop(Team.BLACK);

        standardBoard[3][0] = new Queen(Team.WHITE);
        standardBoard[4][0] = new King(Team.WHITE);
        standardBoard[3][7] = new Queen(Team.BLACK);
        standardBoard[4][7] = new King(Team.BLACK);

        return standardBoard;
    }

    public void move(Move movement){

    }

    public ArrayList<Move> getValidMoves(Integer startFile, Integer startRank){
        AbstractPiece startPiece = board[startFile][startRank];
        ArrayList<Move> potentialMoves = startPiece.getMoves();
        ArrayList<Move> validMoves = new ArrayList<>();
        Integer finalStartFile = startFile;
        Integer finalStartRank = startRank;

        for (Move potentialMove : potentialMoves){
            boolean addPotentialMove = true;
            MoveType moveType = potentialMove.getMoveType();
            Integer endFile = startFile + potentialMove.getMove()[0];
            Integer endRank = startRank + potentialMove.getMove()[1];
            if (((endFile < board.length) && (endFile >= 0)) && ((endRank < board.length) && (endRank >= 0))){
                AbstractPiece endPiece = board[endFile][endRank];

                if (startPiece instanceof Knight){
                    if (endPiece.getTeam() == startPiece.getTeam()){
                        addPotentialMove = false;
                    }
                }

                else if (moveType == MoveType.CANT_CAPTURE) {
                    while (startPiece != endPiece){
                        
                        if (endFile > startFile){
                            startFile++;
                        }

                        else if (endFile < startFile){
                            startFile--;
                        }
                        
                        if (endRank > startRank){
                            startRank++;
                        }

                        else if (endRank < startRank){
                            startRank--;
                        }

                        startPiece = board[startFile][startRank];
                        
                        if (startPiece.getTeam() != Team.NONE){
                            addPotentialMove = false;
                            break;
                        }
                    }
                } else if (moveType == MoveType.CAN_CAPTURE) {
                    while (startPiece != endPiece){
                        
                        if (endFile > startFile){
                            startFile++;
                        }

                        else if (endFile < startFile){
                            startFile--;
                        }
                        
                        if (endRank > startRank){
                            startRank++;
                        }

                        else if (endRank < startRank){
                            startRank--;
                        }

                        startPiece = board[startFile][startRank];
                        
                        if (startPiece.getTeam() != Team.NONE){
                            addPotentialMove = false;
                            break;
                        }
                    }
                }

                startFile = finalStartFile;
                startRank = finalStartRank;
                startPiece = board[startFile][startRank];

                if (addPotentialMove){
                    validMoves.add(potentialMove);
                    
                }
            }
        }
        
        return validMoves;
    }

}
