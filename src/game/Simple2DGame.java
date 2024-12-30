package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Simple2DGame extends JPanel implements KeyListener, Runnable {
    private int playerX = 300, playerY = 300;
    private int playerSize = 20;
    private int speed = 10;
    private List<Enemy> enemies;
    private boolean gameStarted = false;
    private JFrame frame;

    public Simple2DGame(JFrame frame) {
        this.frame = frame;
        setFocusable(true);
        addKeyListener(this);
        enemies = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            enemies.add(new Enemy((int) (Math.random() * 600), (int) (Math.random() * 600), 10, 2, 2));
        }

        new Thread(this).start();
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        if (!gameStarted) {
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 30));
            String startMessage = "Escape the Balls!!";
            g2d.drawString(startMessage, (getWidth() - g2d.getFontMetrics().stringWidth(startMessage)) / 2, getHeight() / 4);

            g2d.setFont(new Font("Arial", Font.PLAIN, 20));
            String startButtonMessage = "Click 'Start' to Begin";
            g2d.drawString(startButtonMessage, (getWidth() - g2d.getFontMetrics().stringWidth(startButtonMessage)) / 2, getHeight() / 2);

            String quitButtonMessage = "Click 'Quit' to Exit";
            g2d.drawString(quitButtonMessage, (getWidth() - g2d.getFontMetrics().stringWidth(quitButtonMessage)) / 2, getHeight() / 2 + 40);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.fillRect(playerX, playerY, playerSize, playerSize);

            g2d.setColor(Color.RED);
            for (Enemy enemy : enemies) {
                g2d.fillOval(enemy.x, enemy.y, enemy.size, enemy.size);
            }
        }
    }

    private void updateGame() {
        List<Enemy> enemiesCopy = new ArrayList<>(enemies);

        for (Enemy enemy : enemiesCopy) {
            enemy.move(getWidth(), getHeight());
        }

        for (Enemy enemy : enemiesCopy) {
            if (playerX < enemy.x + enemy.size &&
                    playerX + playerSize > enemy.x &&
                    playerY < enemy.y + enemy.size &&
                    playerY + playerSize > enemy.y) {
                int result = JOptionPane.showOptionDialog(this, "Game Over!", "Game Over",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Restart", "Quit"}, null);
                if (result == JOptionPane.YES_OPTION) {
                    restartGame();
                } else {
                    System.exit(0);
                }
                break;
            }
        }
    }

    private void restartGame() {
        gameStarted = false;
        playerX = 300;
        playerY = 300;
        enemies.clear();
        for (int i = 0; i < 50; i++) {
            enemies.add(new Enemy((int) (Math.random() * 600), (int) (Math.random() * 600), 10, 2, 2));
        }

        gameStarted = true;
        repaint();
    }

    @Override
    public void run() {
        while (true) {
            if (gameStarted) {
                updateGame();
                repaint();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameStarted) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> {
                    if (playerY - speed >= 0) playerY -= speed;
                }
                case KeyEvent.VK_S -> {
                    if (playerY + playerSize + speed <= getHeight()) playerY += speed;
                }
                case KeyEvent.VK_A -> {
                    if (playerX - speed >= 0) playerX -= speed;
                }
                case KeyEvent.VK_D -> {
                    if (playerX + playerSize + speed <= getWidth()) playerX += speed;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public JPanel createStartScreen() {
        return StartScreen.createStartScreen(this, frame);
    }
}