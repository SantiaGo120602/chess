package com.chess;


import com.chess.model.board.Board;
import com.chess.model.pieces.AbstractPiece;
import com.chess.model.utils.ImageUtils;

public class Main{
    private static String imagesPath = ImageUtils.getImageFolder("resources/images");
    public static void main(String[] args) {
        Board board = new Board();
        AbstractPiece abstractPiece = board.getBoard()[0][6];
        System.out.println(imagesPath + abstractPiece.getPath());
    }
}