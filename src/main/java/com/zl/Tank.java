package com.zl;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
    public int x = 200;
    public int y = 200;
    public int lastX;
    public int lastY;

    public int WIDTH = ResourceManager.tankD.getWidth(), HEIGHT = ResourceManager.tankD.getHeight();
    private final int speed = 2;
    private Dir dir = Dir.DOWN;
    public GameModel gm;

    boolean isEnemy = false;
    boolean live = true;
    private boolean moving = false;
    Random random = new Random();

    FireStrategy fireStrategy;

    private Group group = Group.good;

    public Tank(int x, int y, GameModel gm, Group group, boolean moving) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        this.group = group;
        this.moving = moving;
        if (this.group == Group.good) {
            String goodTankFireStrategy = (String) PropertyMgr.get("goodTankFireStrategy");
            try {
                fireStrategy = (FireStrategy) Class.forName(goodTankFireStrategy).getMethod("getInstance").invoke(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            fireStrategy = DefaultFireStrategy.getInstance();
        }
    }



    @Override
    public void paint(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceManager.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.tankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
        lastX = x;
        lastY = y;
        switch (dir) {
            case LEFT:
                if (x > 0) {
                    x -= speed;
                }
                break;
            case UP:
                if (y > 20) {
                    y -= speed;
                }
                break;
            case RIGHT:
                if (x < gm.GAME_WIDTH - WIDTH) {
                    x += speed;
                }
                break;
            case DOWN:
                if (y < gm.GAME_HEIGHT - HEIGHT) {
                    y += speed;
                }
                break;
        }
        if (group == Group.bad && random.nextInt(10) > 8) {
            switch (random.nextInt(4)) {
                case 0:
                    dir = Dir.LEFT;
                    break;
                case 1:
                    dir = Dir.UP;
                    break;
                case 2:
                    dir = Dir.RIGHT;
                    break;
                case 3:
                    dir = Dir.DOWN;
                    break;
            }
            fire();
        }
    }

    public void fire() {
        fireStrategy.fire(this);
    }

    public void die() {
        Explosion explosion = new Explosion(x, y);
        gm.gameObjects.add(explosion);
        if (group == Group.good) {
            //tf.myTank = null;
        } else {
            gm.gameObjects.remove(this);
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


    public void stop() {
        this.moving = false;
    }

    public void moveToLastDestPosition() {
        x = lastX;
        y = lastY;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "x=" + x +
                ", y=" + y +
                ", lastX=" + lastX +
                ", lastY=" + lastY +
                ", WIDTH=" + WIDTH +
                ", HEIGHT=" + HEIGHT +
                '}';
    }
}
