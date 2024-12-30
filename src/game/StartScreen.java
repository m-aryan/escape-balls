package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen {
    public static JPanel createStartScreen(Simple2DGame game, JFrame frame) {
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new BorderLayout());

        JButton startButton = new JButton("Start New Game");
        JButton quitButton = new JButton("Quit");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setGameStarted(true);
                frame.remove(startPanel);
                frame.add(game);
                frame.revalidate();
                frame.repaint();
                game.requestFocusInWindow();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(quitButton);

        startPanel.add(buttonPanel, BorderLayout.CENTER);

        return startPanel;
    }
}