package com.zl;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {


    private GameModel gm = GameModel.getInstance();

    public TankFrame(){

        setSize(gm.GAME_WIDTH, gm.GAME_HEIGHT);
        setResizable(false);
        setTitle("myTank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
        gm.init();
    }

    @Override
    public void paint(Graphics g) {
        gm.paint(g);

    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(gm.GAME_WIDTH, gm.GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, gm.GAME_WIDTH, gm.GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    class MyKeyListener extends KeyAdapter {

        Tank myTank = gm.getMyTank();

        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;

            }
            setTankDir();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    if (myTank != null) {
                        myTank.fire();
                    }
                    break;
            }
            setTankDir();
        }

        private void setTankDir() {
            if (myTank != null){
                if((!bL && !bU && !bR && !bD)){
                    myTank.setMoving(false);
                }else{
                    myTank.setMoving(true);
                    if(bL) myTank.setDir(Dir.LEFT);;
                    if(bU) myTank.setDir(Dir.UP);
                    if(bR) myTank.setDir(Dir.RIGHT);
                    if(bD) myTank.setDir(Dir.DOWN);
                }
            }

        }
    }

}
