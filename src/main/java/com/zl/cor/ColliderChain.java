package com.zl.cor;

import com.zl.GameObject;
import com.zl.PropertyMgr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider{

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        String collidersStr = PropertyMgr.getString("colliders");
        String[] colliderStrArray = collidersStr.split(",");
        for(String colliderStrItem : colliderStrArray){
            try {
                add((Collider) Class.forName(colliderStrItem).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Collider collider){
        colliders.add(collider);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for(Collider collider : colliders){
            if(!collider.collide(o1, o2)) return false;
        }
        return true;
    }
}
