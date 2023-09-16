package com.chess;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.chess.view.MainFrame;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();

                frame.setSize(2000, 1000);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                frame.setVisible(true);

                frame.getOptionsPanel().getMoveHistoryTextArea().append("adsfasdf");

                frame.getOptionsPanel().getMoveHistoryTextArea().append("holi");
            }
        });
    }
}