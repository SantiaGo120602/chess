package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;
import com.chess.model.other.Team;
import com.chess.model.utils.ImageUtils;

public abstract class AbstractPiece {
    protected static String imagesPath = ImageUtils.getImageFolder("resources/images");
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
        if (path == null){
            path = imagesPath + "/" + team.name().toLowerCase() + "/" + getPieceName();
        }
        return path;
    }


}
