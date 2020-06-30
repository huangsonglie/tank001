package com.zl;

import com.zl.cor.BulletTankCollider;
import com.zl.cor.ColliderChain;
import com.zl.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private final static GameModel INSTANCE = new GameModel();

    public static int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    public Tank myTank = new Tank(200, 200, this, Group.good, false);
    public List<GameObject> gameObjects = new ArrayList<>();

    private ColliderChain colliderChain = new ColliderChain();

    private GameModel(){}

    public static GameModel getInstance(){
        return INSTANCE;
    }

    public void init(){

        for(int x = 100; x <= 800 - 100; x += 140){
            Tank enemyTank = new Tank(x , 100, this, Group.bad, true);
            gameObjects.add(enemyTank);
        }

        //加入一堵墙
        gameObjects.add(new Wall(200, 200, 100, 150));
    }

    public void paint(Graphics g){
        for(int i = 0; i < gameObjects.size(); i++){
            gameObjects.get(i).paint(g);
        }
        if (myTank != null) myTank.paint(g);
        g.setColor(Color.WHITE);
//        g.drawString("当前子弹个数：" + bullets.size(), 10 , 50);
//        g.drawString("当前敌人坦克个数：" + enemyTanks.size(), 10 , 70);

        for(int i = 0; i < gameObjects.size(); i++){
            for(int j = i + 1; j < gameObjects.size(); j++){
                colliderChain.collide(gameObjects.get(i), gameObjects.get(j));
            }
            //if (myTank != null) gameObjects.get(i).impactCheck(myTank);
        }

    }


    public Tank getMyTank() {
        return myTank;
    }
}
