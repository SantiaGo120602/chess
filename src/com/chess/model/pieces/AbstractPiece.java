package com.chess.model.pieces;

public abstract class AbstractPiece {
    protected Team team; 

    public abstract String getUniqueId();
    public abstract void Move(String move);
    public abstract String listMoves();
}
