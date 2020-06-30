package com.zl;

import java.awt.*;

public class Bullet extends GameObject {

    GameModel gm;
    private static final int SPEED = 5;
    public int WIDTH = ResourceManager.bulletD.getWidth(), HEIGHT = ResourceManager.bulletD.getHeight();
    public int x = 0, y = 0;
    Dir dir;
    boolean live = true;

    private Group group = Group.good;

    public Bullet(int x, int y, Dir dir, GameModel gm, Tank tank, Group group){
        this.x = x + tank.WIDTH/2 - WIDTH/2;
        this.y = y + tank.HEIGHT/2 - HEIGHT/2;
        this.dir = dir;
        this.gm = gm;
        this.group = group;

        gm.gameObjects.add(this);
    }


    public void paint(Graphics g){
        switch(dir){
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        if(!live){
            gm.gameObjects.remove(this);
        }
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                 y += SPEED;
                break;
        }

        if(x <= 0 || y <= 0 || x >= gm.GAME_WIDTH || y >= gm.GAME_HEIGHT){ live = false; }
    }


    public void die(){
        live = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


}
