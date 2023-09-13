package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;
import com.chess.model.other.Team;

public class Rook extends AbstractPiece{

    public Rook(Team team){
        this.team = team;
        moves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            moves.add(new Move(new Integer[] {0, i}));
            moves.add(new Move(new Integer[] {0, -i}));
            moves.add(new Move(new Integer[] {i, 0}));
            moves.add(new Move(new Integer[] {-i, 0}));
        }
    }

    @Override
    public String getPieceName(){
        return "rook";
    }
}
