package com.gunblaster.collision;

import java.util.List;

import com.gunblaster.entity.Entity;

public class BoundingBox extends Collision {

    private boolean topCollide;
    private boolean bottomCollide;
    private boolean leftCollide;
    private boolean rightCollide;

    @Override
    public Entity collide(String type) {
        List<Entity> entities = owner.getWorld().getEntities(type);
        float ownerTop = owner.getY();
        float ownerBottom = owner.getY() + owner.getHeight();
        float ownerLeft = owner.getX();
        float ownerRight = owner.getX() + owner.getWidth();

        for (Entity entity : entities) {
            if (!owner.equals(entity)) {
                topCollide = (ownerTop > entity.getY() + entity.getHeight());
                bottomCollide = (ownerBottom < entity.getY());
                leftCollide = (ownerLeft > entity.getX() + entity.getWidth());
                rightCollide = (ownerRight < entity.getX());

                if ( !(topCollide || bottomCollide ||
                        leftCollide || rightCollide)) {
                    return entity;
                }
            }
        }

        return null;
    }

    @Override
    public void collideResponse() {
        // TODO Auto-generated method stub
        
    }

}
