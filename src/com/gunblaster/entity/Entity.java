package com.gunblaster.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.collision.HitDetection;
import com.gunblaster.component.Component;
import com.gunblaster.world.World;

public class Entity {

    protected Vector2f position;
    protected float scale;
    protected float speed;
    protected float alpha;
    protected Image image;
    protected List<Component> components;
    protected String type;
    protected HitDetection hitDetection;
    protected World world;
    protected Map<String, Animation> animations;
    protected int duration = 150;
    protected String currentAnimation;
    protected int width;
    protected int height;

    public Entity() {
        position = new Vector2f(0, 0);
        scale = 1;
        speed = 0.1f;
        alpha = 1.0f;
        components = new ArrayList<Component>();
        animations = new HashMap<String, Animation>();
    }

    public Entity(float x, float y) {
        this();
        position = new Vector2f(x, y);
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
        return width;
    }

    public float getHeight() {
        return height;
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

    public void hitResponse(GameContainer container, StateBasedGame game, int delta) { }

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

    public void addAnimation(SpriteSheet sheet, String name, boolean loop, int frames) {
        Animation animation = new Animation(false);
        animation.setLooping(loop);

        for (int i = 0; i < frames; i++) {
            animation.addFrame(sheet.getSprite(i, 0), duration);
        }

        animations.put(name, animation);
    }

    public void setAnimation(String animation) {
        currentAnimation = animation;

        if (animations.containsKey(currentAnimation)) {
            width = animations.get(currentAnimation).getWidth();
            height = animations.get(currentAnimation).getHeight();
        }
    }

    public void destroy() {
        world.removeEntity(this);
    }

    public void updateAnimation(GameContainer container, int delta) {
        if (animations.containsKey(currentAnimation)) {
            animations.get(currentAnimation).update(delta);
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
        for (Component comp : components) {
            comp.update(container, game, delta);
        }
        hitResponse(container, game, delta);
        updateAnimation(container, delta);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        if (animations.containsKey(currentAnimation)) {
            animations.get(currentAnimation).draw(getX(), getY(), getWidth(), getHeight());
        } else if (image != null) {
            image.draw(position.getX(), position.getY(), scale);
        }
    }

}