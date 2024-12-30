package game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Escape the Balls!!");
        Simple2DGame game = new Simple2DGame(frame);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel startPanel = game.createStartScreen();
        frame.add(startPanel);

        frame.setVisible(true);
    }
}