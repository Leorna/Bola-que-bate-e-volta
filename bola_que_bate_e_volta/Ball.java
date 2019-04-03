package bola_que_bate_e_volta;

import java.awt.Graphics;
import java.awt.Color;

public class Ball implements Settings {
    private int x = 100;
    private int y = 100;
    private int r = RAY;
    private int dx = SPEED_X;
    private int dy = SPEED_X;
    private Color color;

    public void setColor(Color c) {
        this.color = c;
    }

    public void move() {
        if((x + r >= WIDTH) || (x - r <= 0))
            dx = -dx;
        if((y + r >= HEIGHT) || (y - r <= 0))
            dy = -dy;

        x -= dx;
        y += dy;
    }

    public void drawBall(Graphics g) {
        g.setColor(this.color);
        //g.drawArc(x, y, r, r, 0, 360);
        g.fillArc(x, y, r, r, 0, 360);
    }
}
