package com.gunblaster.entity.model;

import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Bullet extends Entity {

    private boolean fired;
    private int timer;

    public Bullet() {
        setType(World.BULLET);
        fired = false;
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