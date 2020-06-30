package com.zl.cor;

import com.zl.Bullet;
import com.zl.GameObject;
import com.zl.Tank;

import java.awt.*;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            if(bullet.getGroup() == tank.getGroup()) return false;
            Rectangle bullentRectangle = new Rectangle(bullet.x, bullet.y, bullet.WIDTH, bullet.HEIGHT);
            Rectangle tankRectangle = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
            if(bullentRectangle.intersects(tankRectangle)){
                bullet.die();
                tank.die();
                return false;
            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet){
            return collide(o2, o1);
        }
        return true;

    }
}
