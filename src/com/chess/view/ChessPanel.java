package com.chess.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ChessPanel extends JPanel{

    private SquareButton[][] squareButtons;

    public ChessPanel(int BOARD_SIZE) {
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        squareButtons = new SquareButton[BOARD_SIZE][BOARD_SIZE];

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                squareButtons[row][col] = new SquareButton(row, col);
                add(squareButtons[row][col]);
            }
        }
    }
}
