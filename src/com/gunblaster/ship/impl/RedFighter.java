package com.gunblaster.ship.impl;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.gunblaster.ship.Ship;

public class RedFighter implements Ship {

    Map<String, Animation> animations = new HashMap<String, Animation>();
    private int duration = 150;

    public RedFighter() {
        initAnimations();
    }

    private void initAnimations() {
        try {
            addAnimation(new SpriteSheet("data/images/player.png", 48, 48), DEFAULT, false, 1);
            addAnimation(new SpriteSheet("data/images/PlayerLeft.png", 48, 48), LEFT, false, 2);
            addAnimation(new SpriteSheet("data/images/PlayerRight.png", 48, 48), RIGHT, false, 2);
            addAnimation(new SpriteSheet("data/images/PlayerExplosion.png", 48, 48), DEAD, false, 17);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private void addAnimation(SpriteSheet sheet, String name, boolean loop, int frames) {
        Animation animation = new Animation(false);
        animation.setLooping(loop);

        for (int i = 0; i < frames; i++) {
            animation.addFrame(sheet.getSprite(i, 0), duration);
        }

        animations.put(name, animation);
    }

    @Override
    public Map<String, Animation> getAnimations() {
        return animations;
    }

}
