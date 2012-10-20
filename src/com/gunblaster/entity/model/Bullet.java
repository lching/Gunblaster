package com.gunblaster.entity.model;

import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Bullet extends Entity {

    private boolean fired;
    private int timer;

    public Bullet(Bullet bullet) {
        this.type = bullet.type;
        this.timer = bullet.timer;
        this.speed = bullet.speed;
        this.image = bullet.image;
        this.position = bullet.position;
        this.fired = bullet.fired;
    }

    public Bullet(int timer, float speed) {
        setType(World.BULLET);
        fired = false;
        this.timer = timer;
        this.speed = speed;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

}