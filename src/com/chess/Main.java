package com.chess;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.chess.controller.ChessController;
import com.chess.model.ChessModel;
import com.chess.model.board.Board;
import com.chess.model.utils.ImageUtils;
import com.chess.view.ChessView;
import com.chess.view.MainFrame;

public class Main{
    public static void main(String[] args) {
        Board board = new Board();
        ChessView view = new ChessView(board, ImageUtils.getImageFolder("src/resources/images"));
        ChessModel model = new ChessModel(board , null, null);
        ChessController controller = new ChessController(model, view);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = controller.getChessView().getMainFrame();
                frame.setSize(2000, 1000);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}