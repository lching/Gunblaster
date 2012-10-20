package com.gunblaster.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.collision.impl.BoundingBox;
import com.gunblaster.component.impl.BasicMoveControl;
import com.gunblaster.entity.Entity;
import com.gunblaster.ship.Ship;
import com.gunblaster.world.World;

public class Player extends Entity {

    private boolean explode = false;
    private Ship ship;

    public Player(float x, float y, Ship ship) {
        super(x, y);
        setType(World.PLAYER);
        setSpeed(0.2f);
        setHitDetection(new BoundingBox());
        this.ship = ship;
        animations.putAll(this.ship.getAnimations());
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
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
    public void updateAnimation(GameContainer container) {
        Input input = container.getInput();

        if ( input.isKeyPressed(Input.KEY_Q) ) {
            setAnimation(Ship.DEAD);
            explode = true;
        }

        if (getComponent(BasicMoveControl.ID) != null && !explode) {
            BasicMoveControl control = (BasicMoveControl) getComponent(BasicMoveControl.ID);

            if ( input.isKeyDown(control.getLeftKey()) ) {
                setAnimation(Ship.LEFT);
            } else if ( input.isKeyDown(control.getRightKey()) ) {
                setAnimation(Ship.RIGHT);
            } else {
                setAnimation(Ship.DEFAULT);
                restartAnimation(Ship.LEFT);
                restartAnimation(Ship.RIGHT);
            }
        }

    }

}
