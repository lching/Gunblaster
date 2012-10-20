package com.gunblaster.bullet.impl;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.gunblaster.bullet.Bullet;
import com.gunblaster.world.World;

public class DefaultBullet extends Bullet {

    public DefaultBullet(int timer, float speed) {
        type = World.BULLET;
        fired = false;
        this.timer = timer;
        this.speed = speed;
        init();
    }

    public void init() {
        try {
            this.image = new Image("data/images/bullet.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isFired() {
        return fired;
    }

    @Override
    public void fired() {
        fired = true;
    }

    @Override
    public int getTimer() {
        return timer;
    }

    @Override
    public void setTimer(int timer) {
        this.timer = timer;
    }

    @Override
    public Bullet copy() {
        Bullet bullet = new DefaultBullet(timer, speed);
        bullet.setType(type);
        bullet.setImage(image);
        bullet.setPosition(position);

        return bullet;
    }

}
