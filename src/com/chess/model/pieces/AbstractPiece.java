package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;
import com.chess.model.other.Team;

public abstract class AbstractPiece {
    protected Team team = Team.NONE;
    protected ArrayList<Move> moves = null;
    protected boolean hasMoved = false;
    protected String path = null;

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

    public abstract String getPieceName();

    public String getPath(){
        if (path == null && team != Team.NONE){
            path = "/" + team.name().toLowerCase() + "/" + getPieceName() + ".png";
        }
        return path;
    }


}
