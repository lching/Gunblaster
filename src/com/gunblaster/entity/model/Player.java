package com.gunblaster.entity.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.gunblaster.entity.Entity;

public class Player extends Entity {

    public Player(String id) {
        super(id);

        //setScale(1.5f);
        setType(Entity.PLAYER);

        try {
            setImage(new Image("data/images/player.png"));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
