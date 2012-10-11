package com.gunblaster.entity.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.gunblaster.collision.BoundingBox;
import com.gunblaster.entity.Entity;

public class Player extends Entity {

    public Player(String id) {
        super(id);

        setType(Entity.PLAYER);
        setCollision(new BoundingBox());

        try {
            setImage(new Image("data/images/player.png"));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
