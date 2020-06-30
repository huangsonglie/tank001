package com.zl.cor;

import com.zl.GameObject;

public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
