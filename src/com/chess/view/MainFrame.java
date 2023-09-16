package com.chess.view;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import com.chess.model.board.Board;
import com.chess.model.utils.ImageUtils;

public class MainFrame extends JFrame{
    private static String imagesPath = ImageUtils.getImageFolder("src/resources/images");
    private ChessPanel chessPanel;
    private OptionsPanel optionsPanel;
    private JPanel mainPanel;

    public ChessPanel getChessPanel() {
        return chessPanel;
    }

    public OptionsPanel getOptionsPanel() {
        return optionsPanel;
    }

    public MainFrame(){
        setTitle("Chess Game");
        mainPanel = new JPanel(new GridBagLayout());
        Board board = new Board();
        
        chessPanel = new ChessPanel(imagesPath, board);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.8;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(chessPanel, gbc);

        optionsPanel = new OptionsPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(optionsPanel, gbc);

        add(mainPanel);


    }
}
