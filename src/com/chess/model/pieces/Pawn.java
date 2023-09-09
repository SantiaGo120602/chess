package com.chess.model.pieces;

public class Pawn extends AbstractPiece{

    public Pawn(Team team){
        this.team = team;
    }
    
    @Override
    public String getUniqueId() {
        throw new UnsupportedOperationException("Unimplemented method 'getUniqueId'");
    }

    @Override
    public void Move(String move) {
        throw new UnsupportedOperationException("Unimplemented method 'Move'");
    }

    @Override
    public String listMoves() {
        throw new UnsupportedOperationException("Unimplemented method 'listMoves'");
    }
    
}
