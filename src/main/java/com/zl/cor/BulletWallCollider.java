package com.zl.cor;

import com.zl.Bullet;
import com.zl.GameObject;
import com.zl.Tank;
import com.zl.Wall;

import java.awt.*;

public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            Rectangle bullentRectangle = new Rectangle(bullet.x, bullet.y, bullet.WIDTH, bullet.HEIGHT);
            Rectangle WallRectangle = new Rectangle(wall.x, wall.y, wall.getWIDTH(), wall.getHEIGHT());
            if(bullentRectangle.intersects(WallRectangle)){
                bullet.die();
                return false;
            }
        }else if (o1 instanceof Wall && o2 instanceof Bullet){
            return collide(o2, o1);
        }
        return true;

    }
}
