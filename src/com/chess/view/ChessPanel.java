package com.chess.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JPanel;
import com.chess.model.board.Board;
import com.chess.model.pieces.AbstractPiece;

public class ChessPanel extends JPanel{
    private static HashMap<Integer, Color> backgroundPiecesMap;
    private final String imagesFolder;
    private final int BOARD_SIZE;
    private SquareButton[][] squareButtons;
    private AbstractPiece[][] abstractPieces; 

    static {
        backgroundPiecesMap = new HashMap<>();
        backgroundPiecesMap.put(0, new Color(50, 50, 50));
        backgroundPiecesMap.put(1, Color.WHITE);
    }


    public ChessPanel(String imagesFolder, Board board) {
        abstractPieces = board.getBoard();
        this.imagesFolder = imagesFolder;
        this.BOARD_SIZE = abstractPieces.length;
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        squareButtons = new SquareButton[BOARD_SIZE][BOARD_SIZE];

        for (int file = 0; file < BOARD_SIZE; file++) {
            for (int rank = 0; rank < BOARD_SIZE; rank++) {
                AbstractPiece abstractPiece = abstractPieces[rank][file];
                String imagePath = imagesFolder + abstractPiece.getPath();
                Color background = backgroundPiecesMap.get((file+rank)%2);
                squareButtons[file][rank] = new SquareButton(background, imagePath, abstractPiece.getTarget());
            }
        }

        for (int file = BOARD_SIZE-1; file >= 0; file--) {
            for (int rank = 0; rank < BOARD_SIZE; rank++) {
                add(squareButtons[file][rank]);
            }
        }
    }

    public void updateSquareButtons(AbstractPiece[][] abstractPieces){
        for (int file = 0; file < BOARD_SIZE; file++) {
            for (int rank = 0; rank < BOARD_SIZE; rank++) {
                AbstractPiece abstractPiece = abstractPieces[rank][file];
                String imagePath = imagesFolder + abstractPiece.getPath();
                Color background = backgroundPiecesMap.get((file+rank)%2);
                squareButtons[file][rank].updateButton(background, imagePath, abstractPiece.getTarget());
            }
        }
    }
}
