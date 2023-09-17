package com.chess.model;

import com.chess.model.board.Board;
import com.chess.model.players.Player;

public class ChessModel {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    
    public ChessModel(Board board, Player whitePlayer, Player blackPlayer) {
        this.board = board;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }
    
    
    
}
