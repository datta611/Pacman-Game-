
import java.awt.*;

public class Maze {
    private final int[][] mazeData = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private static final int TILE_SIZE = 40;

    public void draw(Graphics g) {
        for (int row = 0; row < mazeData.length; row++) {
            for (int col = 0; col < mazeData[row].length; col++) {
                if (mazeData[row][col] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                } else if (mazeData[row][col] == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                    g.setColor(Color.YELLOW);
                    g.fillOval(col * TILE_SIZE + TILE_SIZE / 3, row * TILE_SIZE + TILE_SIZE / 3, TILE_SIZE / 3, TILE_SIZE / 3);
                }
            }
        }
    }

    public boolean isComplete() {
        for (int[] row : mazeData) {
            for (int cell : row) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int collectDot(int x, int y) {
        int row = y / TILE_SIZE;
        int col = x / TILE_SIZE;
        if (mazeData[row][col] == 0) {
            mazeData[row][col] = 2;
            return 10; // Score per dot
        }
        return 0;
    }
}
