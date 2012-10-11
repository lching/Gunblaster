package com.gunblaster.entity.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.gunblaster.entity.Entity;

public class Border extends Entity {

    public Border(String id) {
        super(id);
        setType(Entity.SOLID);

        try {
            setImage(new Image("data/images/border.png"));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
