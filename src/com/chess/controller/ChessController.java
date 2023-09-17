package com.chess.controller;

import com.chess.model.ChessModel;
import com.chess.view.ChessView;

public class ChessController {
    private ChessModel model;
    private ChessView view;
    
    public ChessController(ChessModel chessModel, ChessView chessView) {
        this.model = chessModel;
        this.view = chessView;
    }

    public ChessModel getChessModel() {
        return model;
    }

    public ChessView getChessView() {
        return view;
    }
    
}
