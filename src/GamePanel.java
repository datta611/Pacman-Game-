
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Maze maze;
    private PacMan pacMan;
    private Ghost[] ghosts;
    private int score = 0;

    public GamePanel() {
        this.setFocusable(true);
        this.addKeyListener(this);
        this.maze = new Maze();
        this.pacMan = new PacMan();
        this.ghosts = new Ghost[] { new Ghost(300, 300), new Ghost(400, 300) };
        this.timer = new Timer(100, this);
    }

    public void startGame() {
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        maze.draw(g);
        pacMan.draw(g);
        for (Ghost ghost : ghosts) {
            ghost.draw(g);
        }

        // Display score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pacMan.move(maze);
        for (Ghost ghost : ghosts) {
            ghost.move(maze);
            if (ghost.intersects(pacMan)) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game Over! Final Score: " + score);
                System.exit(0);
            }
        }
        score += maze.collectDot(pacMan.getX(), pacMan.getY());
        if (maze.isComplete()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "You Win! Final Score: " + score);
            System.exit(0);
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pacMan.changeDirection(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
