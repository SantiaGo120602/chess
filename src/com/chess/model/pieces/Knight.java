package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;
import com.chess.model.other.Team;

public class Knight extends AbstractPiece{
    public Knight(Team team){
        this.team = team;
        moves = new ArrayList<>();
        moves.add(new Move(new Integer[] {1, 2}));
        moves.add(new Move(new Integer[] {1, -2}));
        moves.add(new Move(new Integer[] {2, 1}));
        moves.add(new Move(new Integer[] {2, -1}));
        moves.add(new Move(new Integer[] {-1, 2}));
        moves.add(new Move(new Integer[] {-1, -2}));
        moves.add(new Move(new Integer[] {-2, 1}));
        moves.add(new Move(new Integer[] {-2, -1}));
    }

}
