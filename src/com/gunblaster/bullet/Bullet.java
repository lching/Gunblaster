package com.gunblaster.bullet;

import com.gunblaster.entity.Entity;

public abstract class Bullet extends Entity {

    protected boolean fired;
    protected int timer;

    public Bullet() { }

    public Bullet(Bullet bullet) {
        this.type = bullet.type;
        this.timer = bullet.timer;
        this.speed = bullet.speed;
        this.image = bullet.image;
        this.position = bullet.position;
        this.fired = bullet.fired;
    }

    public abstract boolean isFired();
    public abstract void fired();
    public abstract int getTimer();
    public abstract void setTimer(int timer);
    public abstract Bullet copy();

}
