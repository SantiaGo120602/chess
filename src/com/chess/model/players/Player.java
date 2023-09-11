package com.chess.model.players;

import java.util.ArrayList;

import com.chess.model.other.Team;
import com.chess.model.pieces.AbstractPiece;

public class Player {
    private PlayerType playerType;
    private PlayerTimer playerTimer;
    private Team team;
    private ArrayList<AbstractPiece> capturedPieces;

    public Player(PlayerType playerType, PlayerTimer playerTimer, Team team, ArrayList<AbstractPiece> capturedPieces) {
        this.playerType = playerType;
        this.playerTimer = playerTimer;
        this.team = team;
        this.capturedPieces = capturedPieces;
    }
    
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public PlayerTimer getPlayerTimer() {
        return playerTimer;
    }
    public void setPlayerTimer(PlayerTimer playerTimer) {
        this.playerTimer = playerTimer;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public ArrayList<AbstractPiece> getCapturedPieces() {
        return capturedPieces;
    }
    public void setCapturedPieces(ArrayList<AbstractPiece> capturedPieces) {
        this.capturedPieces = capturedPieces;
    }

    
}
