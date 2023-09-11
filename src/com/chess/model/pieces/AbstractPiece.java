package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;

public abstract class AbstractPiece {
    protected Team team = Team.NONE;
    protected ArrayList<Move> moves = null;
    protected boolean hasMoved = false;


    public ArrayList<Move> getMoves() {
        return moves;
    }

    public Team getTeam() {
        return team;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }


}
