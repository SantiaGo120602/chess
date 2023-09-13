package com.chess.view;

import javax.swing.*;
import java.awt.BorderLayout;
import com.chess.model.utils.ImageUtils;

public class MainFrame extends JFrame{
    private static String imagesPath = ImageUtils.getImageFolder("resources/images");
    private ChessPanel chessPanel;
    private OptionsPanel optionsPanel;

    public MainFrame(){
        setTitle("Chess Game");
        setLayout(new BorderLayout());
    }
}
