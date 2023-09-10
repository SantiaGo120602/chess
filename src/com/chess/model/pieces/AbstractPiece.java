package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;

public abstract class AbstractPiece {
    protected Team team;
    protected ArrayList<Move> moves;

    public Team getTeam() {
        return team;
    }

}
