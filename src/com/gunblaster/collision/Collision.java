package com.gunblaster.collision;

import com.gunblaster.entity.Entity;

public abstract class Collision {

    protected Entity owner;

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public abstract Entity collide(String type);
    public abstract void collideResponse();

}
