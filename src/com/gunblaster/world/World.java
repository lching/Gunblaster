package com.gunblaster.world;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.entity.Entity;

public class World {

    public static final String SOLID = "Solid";
    public static final String BULLET = "Bullet";
    public static final String PLAYER = "Player";
    public static final String BORDER = "Border";
    public static final String ENEMY = "Enemy";

    private String name;
    private List<Entity> entities;
    private List<Entity> addable;
    private List<Entity> removable;
    private int width;
    private int height;

    public World(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        addable = new ArrayList<Entity>();
        removable = new ArrayList<Entity>();
        entities = new ArrayList<Entity>();
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addEntity(Entity entity) {
        entity.setWorld(this);
        addable.add(entity);
    }

    public void removeEntity(Entity entity) {
        removable.add(entity);
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
        for (Entity entity : addable) {
            entities.add(entity);
        }

        addable.clear();

        for (Entity entity : removable) {
            entities.remove(entity);
        }

        removable.clear();

        for (Entity entity : entities) {
            entity.update(container, game, delta);
        }
    }

}
