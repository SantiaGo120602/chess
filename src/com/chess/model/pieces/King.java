package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;
import com.chess.model.actions.MoveType;
import com.chess.model.other.Team;

public class King extends AbstractPiece{

    public King(Team team){
        this.team = team;
        moves = new ArrayList<>();
        moves.add(new Move(new Integer[] {0, 1}));
        moves.add(new Move(new Integer[] {0, -1}));
        moves.add(new Move(new Integer[] {1, 0}));
        moves.add(new Move(new Integer[] {-1, 0}));
        moves.add(new Move(new Integer[] {1, 1}));
        moves.add(new Move(new Integer[] {1, -1}));
        moves.add(new Move(new Integer[] {-1, 1}));
        moves.add(new Move(new Integer[] {-1, -1}));
        moves.add(new Move(new Integer[] {-2, 0}, MoveType.CASTLE));
        moves.add(new Move(new Integer[] {2, 0}, MoveType.CASTLE));
    }

    @Override
    public String getPieceName(){
        return "king";
    }

}
