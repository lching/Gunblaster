package com.gunblaster.entity.model;

import org.newdawn.slick.SlickException;

import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Bullet extends Entity {

    private Entity owner;
    private boolean fired;

    public Bullet() {
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

    public void destroy() {
        try {
            super.image.destroy();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
