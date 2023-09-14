package com.chess.model.board;

import java.util.ArrayList;

import com.chess.model.actions.Move;
import com.chess.model.actions.MoveType;
import com.chess.model.other.Team;
import com.chess.model.pieces.AbstractPiece;
import com.chess.model.pieces.Bishop;
import com.chess.model.pieces.EmptyPiece;
import com.chess.model.pieces.King;
import com.chess.model.pieces.Knight;
import com.chess.model.pieces.Pawn;
import com.chess.model.pieces.Queen;
import com.chess.model.pieces.Rook;

public class Board {
    private AbstractPiece[][] board;
    
    public AbstractPiece[][] getBoard() {
        return board;
    }

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

    public AbstractPiece commitMove(Integer startFile, Integer startRank, Move movement){
        AbstractPiece startPiece = board[startFile][startRank];
        Integer endFile = startFile + movement.getMove()[0];
        Integer endRank = startRank + movement.getMove()[1];
        AbstractPiece capturedPiece = board[endFile][endRank];

        if (movement.getMoveType() == MoveType.CASTLE){
            if (endFile == 6){
                board[5][endRank] = board[7][endRank];
                board[5][endRank].setHasMoved(true);
                board[7][endRank] = new EmptyPiece();
            } else {
                board[3][endRank] = board[0][endRank];
                board[3][endRank].setHasMoved(true);
                board[0][endRank] = new EmptyPiece();
            }
        } else if (movement.getMoveType() == MoveType.EN_PASSANT){
            capturedPiece = board[endFile][startRank];
            board[endFile][startRank] = new EmptyPiece();
        }

        board[endFile][endRank] = startPiece;
        if (!board[endFile][endRank].isHasMoved()){
            board[endFile][endRank].setHasMoved(true);
        }
        board[startFile][startRank] = new EmptyPiece();
        return capturedPiece;
    }

    public ArrayList<Move> getValidMoves(Integer startFile, Integer startRank){
        AbstractPiece startPiece = board[startFile][startRank];
        ArrayList<Move> potentialMoves = startPiece.getMoves();
        ArrayList<Move> validMoves = new ArrayList<>();
        Integer finalStartFile = startFile;
        Integer finalStartRank = startRank;
        Team finalStartTeam = startPiece.getTeam();

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
                } else if ((startPiece instanceof Pawn) && (startPiece.isHasMoved()) && (potentialMove.getMove()[1] == 2)){
                    addPotentialMove = false;
                } else if (moveType == MoveType.CANT_CAPTURE) {
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
                            if (startPiece == endPiece){
                                if (startPiece.getTeam() != finalStartTeam){
                                    break;
                                }
                            }
                            addPotentialMove = false;
                            break;
                        }
                    }
                } else if (moveType == MoveType.MUST_CAPTURE){
                    if (endPiece.getTeam() == finalStartTeam || endPiece.getTeam() == Team.NONE){
                        addPotentialMove = false;
                    }
                } else if (moveType == MoveType.EN_PASSANT){
                    AbstractPiece flagPiece = board[startFile+potentialMove.getMove()[0]][startRank];
                    if ((endPiece.getTeam() != Team.NONE) || (flagPiece.getTeam() == finalStartTeam || flagPiece.getTeam() == Team.NONE) || !(flagPiece instanceof Pawn)){
                            addPotentialMove = false;
                    }
                } else if (moveType == MoveType.CASTLE){
                    if (!startPiece.isHasMoved()){
                        if (potentialMove.getMove()[0] > 0){
                            for (int i = startFile+1; i < 7; i++){
                                if (board[i][startRank].getTeam() != Team.NONE){
                                    addPotentialMove = false;
                                    break;
                                } 
                            }
                            if (board[7][startRank].isHasMoved()){
                                addPotentialMove = false;
                            }
                        } else {
                            for (int i = startFile-1; i > 0; i--){
                                if (board[i][startRank].getTeam() != Team.NONE){
                                    addPotentialMove = false;
                                    break;
                                } 
                            }
                            if (board[0][startRank].isHasMoved()){
                                addPotentialMove = false;
                            }
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
