package com.gunblaster.entity.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.gunblaster.entity.Entity;

public class Wall extends Entity {

    public Wall(String id) {
        super(id);
        setPosition(new Vector2f(400, 300));
        setType(Entity.SOLID);

        try {
            setImage(new Image("data/images/player.png"));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
