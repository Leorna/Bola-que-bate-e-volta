package bola_que_bate_e_volta;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Window extends JFrame implements Runnable, Settings {
    private Ball ball = new Ball();
    private Random rand = new Random();

    private JPanel panel = new JPanel() {
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ball.drawBall(g);
            repaint();
        }
    };

    @Override public void run() {
        while(true) {
            ball.move();
            ball.setColor(new Color(
                    rand.nextInt(255),
                    rand.nextInt(255),
                    rand.nextInt(255)
            ));
            try {
                Thread.sleep(100);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void window() {
        setSize(Settings.WIDTH, Settings.HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
    }

    private Window() {
        super("Bola que bate e volta");
        window();
        new Thread(this).start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
