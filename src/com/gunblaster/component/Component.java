package com.gunblaster.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.entity.Entity;

public abstract class Component {

    protected String id;
    protected Entity owner;

    public String getId() {
        return id;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public abstract void init();
    public abstract void update(GameContainer container, StateBasedGame game, int delta);

}