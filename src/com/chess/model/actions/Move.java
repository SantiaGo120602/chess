package com.chess.model.actions;

public class Move {
    private Integer[] move;
    private boolean canCaptrue;

    public Move(Integer[] move, boolean canCaptrue) {
        this.move = move;
        this.canCaptrue = canCaptrue;
    }

    public Integer[] getMove() {
        return move;
    }
    
    public boolean isCanCaptrue() {
        return canCaptrue;
    }
    
}
