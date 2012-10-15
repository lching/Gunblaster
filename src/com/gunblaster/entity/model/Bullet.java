package com.gunblaster.entity.model;

import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Bullet extends Entity {

    private Entity owner;
    private boolean fired;

    public Bullet(String id) {
        super(id);
        setType(World.BULLET);
        fired = false;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public Entity getOwner() {
        return owner;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

}
