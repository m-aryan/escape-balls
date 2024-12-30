package game;

public class Enemy {
    int x, y, size, dx, dy;

    public Enemy(int x, int y, int size, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        this.dy = dy;
    }

    public void move(int width, int height) {
        x += dx;
        y += dy;

        if (x <= 0 || x + size >= width) dx = -dx;
        if (y <= 0 || y + size >= height) dy = -dy;
    }
}