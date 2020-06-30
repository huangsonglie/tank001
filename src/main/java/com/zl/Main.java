package com.zl;

public class Main {
    public static void main(String[] args) {
        TankFrame tank = new TankFrame();
        while(true){
            tank.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
