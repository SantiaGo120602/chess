package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;

public class Queen extends AbstractPiece{
    public Queen(Team team){
        this.team = team;
        moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            moves.add(new Move(new Integer[] {0, i}));
            moves.add(new Move(new Integer[] {0, -i}));
            moves.add(new Move(new Integer[] {i, 0}));
            moves.add(new Move(new Integer[] {-i, 0}));
            moves.add(new Move(new Integer[] {i, i}));
            moves.add(new Move(new Integer[] {i, -i}));
            moves.add(new Move(new Integer[] {-i, i}));
            moves.add(new Move(new Integer[] {-i, -i}));
        }
    }

}
