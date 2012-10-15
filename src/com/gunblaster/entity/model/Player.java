package com.gunblaster.entity.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.gunblaster.collision.impl.BoundingBox;
import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Player extends Entity {

    public Player() {
        setType(World.PLAYER);
        setHitDetection(new BoundingBox());
        
        try {
            setImage(new Image("data/images/player.png"));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
