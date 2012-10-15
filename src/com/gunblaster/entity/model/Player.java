package com.gunblaster.entity.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.gunblaster.collision.impl.BoundingBox;
import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Player extends Entity {

    private Bullet bullet;

    public Player(String id) {
        super(id);

        setType(World.PLAYER);
        setHitDetection(new BoundingBox());
        
        try {
            setImage(new Image("data/images/player.png"));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
        this.bullet.setPosition(new Vector2f(getX(), getY()));
        this.bullet.setOwner(this);
        this.bullet.setSpeed(1.0f);

        try {
            this.bullet.setImage(new Image("data/images/bullet.png"));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
