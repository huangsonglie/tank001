package com.zl;


public final class FourDirFireStrategy implements FireStrategy{

    private static final FourDirFireStrategy fourDirFire = new FourDirFireStrategy();

    private FourDirFireStrategy(){}

    public static FourDirFireStrategy getInstance(){
        return fourDirFire;
    }

    @Override
    public void fire(Tank tank) {
        int x = tank.x;
        int y = tank.y;
        Group group = tank.getGroup();
        for(Dir dir : Dir.values()){
            Bullet bullet = new Bullet(x, y, dir, tank.gm, tank, group);
        }
    }
}
