package com.chess.view;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import com.chess.model.board.Board;
import com.chess.model.pieces.AbstractPiece;
import com.chess.model.utils.ImageUtils;

public class MainFrame extends JFrame{
    private static String imagesPath = ImageUtils.getImageFolder("src/resources/images");
    private ChessPanel chessPanel;
    private OptionsPanel optionsPanel;
    private JPanel mainPanel;

    public MainFrame(){
        setTitle("Chess Game");
        mainPanel = new JPanel(new GridBagLayout());
        AbstractPiece[][] board = new Board().getBoard();
        board[1][0].setTarget(true);
        board[1][1].setTarget(true);
        board[2][2].setTarget(true);
        board[2][6].setTarget(true);
        chessPanel = new ChessPanel(imagesPath, 8, board);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(chessPanel, gbc);

        optionsPanel = new OptionsPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(optionsPanel, gbc);

        add(mainPanel);


    }
}
