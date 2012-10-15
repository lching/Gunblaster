package com.gunblaster.collision;

import com.gunblaster.entity.Entity;

public abstract class HitDetection {

    protected Entity owner;

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public abstract Entity hit(String type);

}
