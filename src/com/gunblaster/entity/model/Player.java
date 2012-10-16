package com.gunblaster.entity.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.collision.impl.BoundingBox;
import com.gunblaster.entity.Entity;
import com.gunblaster.world.World;

public class Player extends Entity {

    private int key_up;
    private int key_left;
    private int key_right;
    private int key_down;
    private int key_fire;

    public Player(float x, float y) {
        super(x, y);
        setType(World.PLAYER);
        setHitDetection(new BoundingBox());
    }

    public void setMovementKeys(int up, int left, int right, int down) {
        key_up = up;
        key_left = left;
        key_right = right;
        key_down = down;
    }

    public void setKeyFire(int fire) {
        key_fire = fire;
    }

    public int getKeyUp() {
        return key_up;
    }

    public int getKeyLeft() {
        return key_left;
    }

    public int getKeyRight() {
        return key_right;
    }

    public int getKeyDown() {
        return key_down;
    }

    public int getKeyFire() {
        return key_fire;
    }

    public void hitResponse(GameContainer container, StateBasedGame game, int delta) {
        Input input = container.getInput();

        if ( input.isKeyDown(getKeyDown()) && (hit(World.SOLID) != null || position.y + getHeight() > world.getHeight()) ) {
            position.y -= speed * delta;
        }

        if ( input.isKeyDown(getKeyUp()) && (hit(World.SOLID) != null || position.y < 0) ) {
            position.y += speed * delta;
        }

        if ( input.isKeyDown(getKeyRight()) && (hit(World.SOLID) != null || position.x + getWidth() > world.getWidth()) ) {
            position.x -= speed * delta;
        }

        if ( input.isKeyDown(getKeyLeft()) && (hit(World.SOLID) != null || position.x < 0) ) {
            position.x += speed * delta;
        }
    }

}
