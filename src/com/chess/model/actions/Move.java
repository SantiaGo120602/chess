package com.chess.model.actions;

public class Move {
    private Integer[] move;
    private MoveType moveType;

    public Move(Integer[] move, MoveType moveType) {
        this.move = move;
        this.moveType = moveType;
    }

    public Move(Integer[] move) {
        this.move = move;
        this.moveType = MoveType.CAN_CAPTURE;
    }

    public Integer[] getMove() {
        return move;
    }

    public MoveType getMoveType() {
        return moveType;
    }
    
}
