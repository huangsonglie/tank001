package com.zl;

import java.awt.*;

public class Wall extends GameObject{

    private int WIDTH;
    private int HEIGHT;

    public Wall(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
