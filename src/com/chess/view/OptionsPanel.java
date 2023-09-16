package com.chess.view;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private JLabel player1TimerLabel;
    private JLabel player2TimerLabel;
    private JTextArea moveHistoryTextArea;
    private JPanel player1CapturePanel;
    private JPanel player2CapturePanel;

    public JLabel getPlayer1TimerLabel() {
        return player1TimerLabel;
    }

    public void setPlayer1TimerLabel(JLabel player1TimerLabel) {
        this.player1TimerLabel = player1TimerLabel;
    }

    public JLabel getPlayer2TimerLabel() {
        return player2TimerLabel;
    }

    public void setPlayer2TimerLabel(JLabel player2TimerLabel) {
        this.player2TimerLabel = player2TimerLabel;
    }

    public JTextArea getMoveHistoryTextArea() {
        return moveHistoryTextArea;
    }

    public void setMoveHistoryTextArea(JTextArea moveHistoryTextArea) {
        this.moveHistoryTextArea = moveHistoryTextArea;
    }

    public JPanel getPlayer1CapturePanel() {
        return player1CapturePanel;
    }

    public void setPlayer1CapturePanel(JPanel player1CapturePanel) {
        this.player1CapturePanel = player1CapturePanel;
    }

    public JPanel getPlayer2CapturePanel() {
        return player2CapturePanel;
    }

    public void setPlayer2CapturePanel(JPanel player2CapturePanel) {
        this.player2CapturePanel = player2CapturePanel;
    }

    public OptionsPanel() {
        setLayout(new BorderLayout());

        Font timerFont = new Font("Arial", Font.BOLD, 24);
        player1TimerLabel = new JLabel("Player 1 Timer: 00:00");
        player2TimerLabel = new JLabel("Player 2 Timer: 00:00");
        player1TimerLabel.setFont(timerFont);
        player2TimerLabel.setFont(timerFont);

        JPanel timerPanel = new JPanel(new GridLayout(2, 1));
        timerPanel.add(player1TimerLabel);
        timerPanel.add(player2TimerLabel);
        add(timerPanel, BorderLayout.NORTH);

        player1CapturePanel = new JPanel();
        player2CapturePanel = new JPanel();
        player1CapturePanel.setPreferredSize(new Dimension(100, 100));
        player2CapturePanel.setPreferredSize(new Dimension(100, 100));
        player1CapturePanel.setBorder(BorderFactory.createTitledBorder("Player 1 Captures"));
        player2CapturePanel.setBorder(BorderFactory.createTitledBorder("Player 2 Captures"));

        moveHistoryTextArea = new JTextArea();
        moveHistoryTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(moveHistoryTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel historyPanel = new JPanel(new BorderLayout());
        historyPanel.setPreferredSize(new Dimension(200, 200));
        historyPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel captureAndHistoryPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        captureAndHistoryPanel.add(player1CapturePanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        captureAndHistoryPanel.add(player2CapturePanel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        captureAndHistoryPanel.add(historyPanel, gbc);

        add(captureAndHistoryPanel, BorderLayout.CENTER);
    }

}
