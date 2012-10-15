package com.gunblaster.entity.model;

import com.gunblaster.collision.impl.BoundingBox;
import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Player extends Entity {

    public Player(float x, float y) {
        super(x, y);
        setType(World.PLAYER);
        setHitDetection(new BoundingBox());
    }

}
