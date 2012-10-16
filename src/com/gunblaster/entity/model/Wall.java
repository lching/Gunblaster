package com.gunblaster.entity.model;

import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Wall extends Entity {

    public Wall(float x, float y) {
        super(x, y);
        type = World.SOLID; 
    }

}
