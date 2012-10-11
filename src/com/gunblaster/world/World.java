package com.gunblaster.world;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.entity.Entity;

public class World {

    private String name;
    private List<Entity> entities;

    public World(String name) {
        this.name = name;
        entities = new ArrayList<Entity>();
    }

    public String getName() {
        return name;
    }

    public void addEntity(Entity entity) {
        entity.setWorld(this);
        entities.add(entity);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Entity> getEntities(String type) {
        List<Entity> ent = new ArrayList<Entity>();

        for (Entity entity : entities) {
            if (entity.getType() == type) {
                ent.add(entity);
            }
        }

        return ent;
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        for (Entity entity : entities) {
            entity.render(container, game, g);
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        for (Entity entity : entities) {
            entity.update(container, game, delta);
        }
    }

}
