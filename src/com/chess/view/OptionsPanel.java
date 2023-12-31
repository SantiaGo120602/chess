package com.chess.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class OptionsPanel extends JPanel {
    private JLabel whitePlaterTimerLabel;
    private JLabel blackPlayerTimerLabel;
    private JTextArea moveHistoryTextArea;
    private JPanel whitePlaterCapturePanel;
    private JPanel blackPlayerCapturePanel;

    public JLabel getwhitePlaterTimerLabel() {
        return whitePlaterTimerLabel;
    }

    public JLabel getblackPlayerTimerLabel() {
        return blackPlayerTimerLabel;
    }

    public JTextArea getMoveHistoryTextArea() {
        return moveHistoryTextArea;
    }

    public JPanel getwhitePlaterCapturePanel() {
        return whitePlaterCapturePanel;
    }

    public JPanel getblackPlayerCapturePanel() {
        return blackPlayerCapturePanel;
    }

    public OptionsPanel() {
        setLayout(new BorderLayout());

        Font timerFont = new Font("Arial", Font.BOLD, 34);
        Font titleFont = new Font("Arial", Font.BOLD, 30);

        whitePlaterTimerLabel = new JLabel("   " + "00:00");
        blackPlayerTimerLabel = new JLabel("        " + "00:00");
        whitePlaterTimerLabel.setFont(timerFont);
        blackPlayerTimerLabel.setFont(timerFont);

        JPanel timerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        timerPanel.add(whitePlaterTimerLabel);
        timerPanel.add(blackPlayerTimerLabel);
        timerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(timerPanel, BorderLayout.NORTH);

        whitePlaterCapturePanel = new JPanel();
        blackPlayerCapturePanel = new JPanel();
        whitePlaterCapturePanel.setPreferredSize(new Dimension(100, 100));
        blackPlayerCapturePanel.setPreferredSize(new Dimension(100, 100));
        TitledBorder whiteBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "white");
        whiteBorder.setTitleFont(titleFont);
        whitePlaterCapturePanel.setBorder(whiteBorder);
        TitledBorder blackBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "black");
        blackBorder.setTitleFont(titleFont);
        blackPlayerCapturePanel.setBorder(blackBorder);

        moveHistoryTextArea = new JTextArea();
        moveHistoryTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(moveHistoryTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JLabel titleLabel = new JLabel("History");
        titleLabel.setFont(titleFont); 
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(titleLabel);

        JPanel historyPanel = new JPanel(new BorderLayout());
        historyPanel.setPreferredSize(new Dimension(120, 120));
        historyPanel.add(scrollPane, BorderLayout.CENTER);
        historyPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel captureAndHistoryPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        captureAndHistoryPanel.add(whitePlaterCapturePanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        captureAndHistoryPanel.add(blackPlayerCapturePanel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        captureAndHistoryPanel.add(historyPanel, gbc);

        add(captureAndHistoryPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton pauseButton = new JButton("Pause");
        pauseButton.setPreferredSize(new Dimension(90, 30));
        southPanel.add(pauseButton);

        JButton loadReplayButton = new JButton("Load Replay");
        loadReplayButton.setPreferredSize(new Dimension(130, 30));
        southPanel.add(loadReplayButton);

        String[] options_playerWhite = {"Human", "Patrick"};
        JComboBox<String> playerWhite = new JComboBox<>(options_playerWhite);
        playerWhite.setPreferredSize(new Dimension(90, 30));
        southPanel.add(playerWhite);
        
        String[] options_playerBlack = {"Human", "Patrick"};
        JComboBox<String> playerBlack = new JComboBox<>(options_playerBlack);
        playerBlack.setPreferredSize(new Dimension(90, 30));
        southPanel.add(playerBlack);

        JButton leftArrowButton = new JButton("<");
        JButton rightArrowButton = new JButton(">");
        leftArrowButton.setPreferredSize(new Dimension(50, 30));
        rightArrowButton.setPreferredSize(new Dimension(50, 30));
        southPanel.add(leftArrowButton);
        southPanel.add(rightArrowButton);

        add(southPanel, BorderLayout.SOUTH);
    }

}
