package com.zl.cor;

import com.zl.GameObject;
import com.zl.Tank;

import java.awt.*;

public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank){
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;
            Rectangle tankRectangle1 = new Rectangle(tank1.getX(), tank1.getY(), tank1.WIDTH, tank1.HEIGHT);
            Rectangle tankRectangle2 = new Rectangle(tank2.getX(), tank2.getY(), tank2.WIDTH, tank2.HEIGHT);
            if(tankRectangle1.intersects(tankRectangle2)){
                tank1.moveToLastDestPosition();
                tank2.moveToLastDestPosition();
            }

        }
        return true;
    }
}
