package com.zl;

public final class DefaultFireStrategy implements FireStrategy{

    private static final DefaultFireStrategy defaultFireStrategy = new DefaultFireStrategy();

    private DefaultFireStrategy(){}

    public static DefaultFireStrategy getInstance(){
        return defaultFireStrategy;
    }

    @Override
    public void fire(Tank tank) {
        Bullet bulletT = new Bullet(tank.x, tank.y, tank.getDir(), tank.gm, tank, tank.getGroup());
    }
}
