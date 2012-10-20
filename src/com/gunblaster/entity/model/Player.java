package com.gunblaster.entity.model;

import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.collision.impl.BoundingBox;
import com.gunblaster.component.player.BasicMoveControl;
import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Player extends Entity {

    private boolean explode = false;

    public Player(float x, float y) {
        super(x, y);
        setType(World.PLAYER);
        setSpeed(0.2f);
        setHitDetection(new BoundingBox());

        try {
            addAnimation(new SpriteSheet("data/images/player.png", 48, 48), "DEFAULT", false, 1);
            addAnimation(new SpriteSheet("data/images/PlayerLeft.png", 48, 48), "LEFT", false, 2);
            addAnimation(new SpriteSheet("data/images/PlayerRight.png", 48, 48), "RIGHT", false, 2);
            addAnimation(new SpriteSheet("data/images/PlayerExplosion.png", 48, 48), "BOOM", false, 17);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void hitResponse(GameContainer container, StateBasedGame game, int delta) {
        Input input = container.getInput();

        if (getComponent(BasicMoveControl.ID) != null) {
            BasicMoveControl control = (BasicMoveControl) getComponent(BasicMoveControl.ID);
            if ( input.isKeyDown(control.getDownKey()) && (hit(World.SOLID) != null || position.y + getHeight() > world.getHeight()) ) {
                position.y -= speed * delta;
            }

            if ( input.isKeyDown(control.getUpKey()) && (hit(World.SOLID) != null || position.y < 0) ) {
                position.y += speed * delta;
            }

            if ( input.isKeyDown(control.getRightKey()) && (hit(World.SOLID) != null || position.x + getWidth() > world.getWidth()) ) {
                position.x -= speed * delta;
            }

            if ( input.isKeyDown(control.getLeftKey()) && (hit(World.SOLID) != null || position.x < 0) ) {
                position.x += speed * delta;
            }
        }
    }

    @Override
    public void updateAnimation(GameContainer container, int delta) {
        super.updateAnimation(container, delta);
        Input input = container.getInput();

        if ( input.isKeyPressed(Input.KEY_Q) ) {
            setAnimation("BOOM");
            explode = true;
        }

        if (getComponent(BasicMoveControl.ID) != null && !explode) {
            BasicMoveControl control = (BasicMoveControl) getComponent(BasicMoveControl.ID);

            if ( input.isKeyDown(control.getLeftKey()) ) {
                setAnimation("LEFT");
            } else if ( input.isKeyDown(control.getRightKey()) ) {
                setAnimation("RIGHT");
            } else {
                setAnimation("DEFAULT");
                for (Map.Entry<String, Animation> entry : animations.entrySet()) {
                    animations.get(entry.getKey()).restart();
                }
            }
        }

    }

}
