package com.chess.model.pieces;

import java.util.ArrayList;

import com.chess.model.actions.Move;
import com.chess.model.actions.MoveType;

public class Pawn extends AbstractPiece{

    public Pawn(Team team){
        this.team = team;
        moves = new ArrayList<>();
        if (team == Team.WHITE) {
            moves.add(new Move(new Integer[] {0, 1}, MoveType.CANT_CAPTURE));
            moves.add(new Move(new Integer[] {0, 2}, MoveType.CANT_CAPTURE));
            moves.add(new Move(new Integer[] {1, 1}, MoveType.MUST_CAPTURE));
            moves.add(new Move(new Integer[] {-1, 1}, MoveType.MUST_CAPTURE));
            moves.add(new Move(new Integer[] {1, 1}, MoveType.EN_PASSANT));
            moves.add(new Move(new Integer[] {-1, 1}, MoveType.EN_PASSANT));
        } else {
            moves.add(new Move(new Integer[] {0, -1}, MoveType.CANT_CAPTURE));
            moves.add(new Move(new Integer[] {0, -2}, MoveType.CANT_CAPTURE));
            moves.add(new Move(new Integer[] {1, -1}, MoveType.MUST_CAPTURE));
            moves.add(new Move(new Integer[] {-1, -1}, MoveType.MUST_CAPTURE));
            moves.add(new Move(new Integer[] {1, -1}, MoveType.EN_PASSANT));
            moves.add(new Move(new Integer[] {-1, -1}, MoveType.EN_PASSANT));
        }
    }
    
}
