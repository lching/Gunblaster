package com.gunblaster.collision.impl;

import java.util.List;

import com.gunblaster.collision.HitDetection;
import com.gunblaster.entity.Entity;

public class BoundingBox extends HitDetection {

    private boolean topCollide;
    private boolean bottomCollide;
    private boolean leftCollide;
    private boolean rightCollide;

    @Override
    public Entity hit(String type) {
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

}
