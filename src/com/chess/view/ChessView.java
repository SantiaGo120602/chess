package com.chess.view;

import com.chess.model.board.Board;
import java.awt.event.ActionListener;

public class ChessView {
    private MainFrame mainFrame;
    
    public ChessView(Board board, String imagesPath){
        this.mainFrame = new MainFrame(board, imagesPath);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void addAddBoardListener(ActionListener listener) {
        mainFrame.getChessPanel().addActionListener(listener);
    }
}
