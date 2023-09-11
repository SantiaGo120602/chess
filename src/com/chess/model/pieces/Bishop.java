package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;

public class Bishop extends AbstractPiece{
    public Bishop(Team team){
        this.team = team;
        moves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            moves.add(new Move(new Integer[] {i, i}));
            moves.add(new Move(new Integer[] {i, -i}));
            moves.add(new Move(new Integer[] {-i, i}));
            moves.add(new Move(new Integer[] {-i, -i}));
        }
    }

}
