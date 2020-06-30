package com.zl;


import java.awt.*;

public class Explosion extends GameObject {

    TankFrame tf;
    int x = 0, y = 0;
    private int step = 0;
    int WIDTH = ResourceManager.explosions.get(0).getWidth(), HEIGHT = ResourceManager.explosions.get(0).getHeight();


    public Explosion(int x, int y){
        this.x = x;
        this.y = y;
        //new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){
        if(step >= 15){
            return;
        }
        g.drawImage(ResourceManager.explosions.get(step++), x, y, null);

    }

}
