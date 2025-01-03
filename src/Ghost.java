
import java.awt.*;
import java.util.Random;

public class Ghost {
    private int x, y;
    private int directionX = 0, directionY = 0;
    private static final int TILE_SIZE = 40;
    private Random random = new Random();

    public Ghost(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        changeDirection();
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
    }

    public void move(Maze maze) {
        int nextX = x + directionX * TILE_SIZE;
        int nextY = y + directionY * TILE_SIZE;

        if (!maze.isWall(nextX, nextY)) {
            x = nextX;
            y = nextY;
        } else {
            changeDirection();
        }
    }

    public void changeDirection() {
        int[] directions = {-1, 0, 1};
        directionX = directions[random.nextInt(3)];
        directionY = directions[random.nextInt(3)];
        if (directionX == 0 && directionY == 0) {
            directionX = 1;
        }
    }

    public boolean intersects(PacMan pacMan) {
        return x == pacMan.getX() && y == pacMan.getY();
    }
}
