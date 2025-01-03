
import java.awt.*;

public class PacMan {
    private int x = 40, y = 40;
    private int directionX = 0, directionY = 0;
    private static final int TILE_SIZE = 40;

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillArc(x, y, TILE_SIZE, TILE_SIZE, 30, 300);
    }

    public void move(Maze maze) {
        int nextX = x + directionX * TILE_SIZE;
        int nextY = y + directionY * TILE_SIZE;

        if (!maze.isWall(nextX, nextY)) {
            x = nextX;
            y = nextY;
        }
    }

    public void changeDirection(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                directionX = 0;
                directionY = -1;
                break;
            case KeyEvent.VK_DOWN:
                directionX = 0;
                directionY = 1;
                break;
            case KeyEvent.VK_LEFT:
                directionX = -1;
                directionY = 0;
                break;
            case KeyEvent.VK_RIGHT:
                directionX = 1;
                directionY = 0;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
