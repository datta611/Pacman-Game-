
import javax.swing.*;

public class PacManGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pac-Man");
        GamePanel panel = new GamePanel();

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        panel.startGame();
    }
}
