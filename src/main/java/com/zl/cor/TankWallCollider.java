package com.zl.cor;

import com.zl.GameObject;
import com.zl.Tank;
import com.zl.Wall;

import java.awt.*;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Wall){
            Tank tank1 = (Tank) o1;
            Wall wall = (Wall) o2;
            Rectangle tankRectangle1 = new Rectangle(tank1.getX(), tank1.getY(), tank1.WIDTH, tank1.HEIGHT);
            Rectangle WallRectangle = new Rectangle(wall.x, wall.y, wall.getWIDTH(), wall.getHEIGHT());
            if(tankRectangle1.intersects(WallRectangle)){
                tank1.moveToLastDestPosition();
            }

        }
        return true;
    }
}
