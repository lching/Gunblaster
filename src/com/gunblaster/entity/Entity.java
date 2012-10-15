package com.gunblaster.entity;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.collision.HitDetection;
import com.gunblaster.component.Component;
import com.gunblaster.entity.model.Bullet;
import com.gunblaster.world.World;

public class Entity {

    private String id;
    private Vector2f position;
    private float scale;
    private float speed;
    private float alpha;
    private Image image;
    private List<Component> components;
    private String type;
    private HitDetection hitDetection;
    private World world;

    public Entity(String id) {
        this.id = id;
        position = new Vector2f(0, 0);
        scale = 1;
        speed = 0.1f;
        alpha = 1.0f;
        components = new ArrayList<Component>();
    }

    public String getId() {
        return id;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public float getWidth() {
        return image.getWidth();
    }

    public float getHeight() {
        return image.getHeight();
    }

    public float getX() {
        return position.getX();
    }

    public float getY() {
        return position.getY();
    }

    public void setHitDetection(HitDetection hitDetection) {
        hitDetection.setOwner(this);
        this.hitDetection = hitDetection;
    }

    public boolean hasHitDetection() {
        return hitDetection != null;
    }

    public Entity hit(String type) {
        if (hasHitDetection()) {
            return hitDetection.hit(type);
        }

        return null;
    }

    public void setVisible(boolean visible) {
        if (!visible) {
            alpha = 0.0f;
        } else {
            alpha = 1.0f;
        }

        if (image != null) {
            image.setAlpha(alpha);
        }
    }

    public List<Component> getComponents() {
        return components;
    }

    public void addComponent(Component component) {
        component.setOwner(this);
        components.add(component);
    }

    public Component getComponent(String id) {
        for (Component comp : components) {
            if (comp.getId().equalsIgnoreCase(id)) {
                return comp;
            }
        }

        return null;
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
        for (Component comp : components) {
            comp.update(container, game, delta);
        }
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        image.draw(position.getX(), position.getY(), scale);
    }

}