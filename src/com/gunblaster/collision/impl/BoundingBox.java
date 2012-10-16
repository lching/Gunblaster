package com.gunblaster.collision.impl;

import java.util.List;

import com.gunblaster.collision.HitDetection;
import com.gunblaster.entity.Entity;

public class BoundingBox extends HitDetection {

    @Override
    public Entity hit(String type) {
        List<Entity> entities = owner.getWorld().getEntities(type);
        float ownerTop = owner.getY();
        float ownerBottom = owner.getY() + owner.getHeight();
        float ownerLeft = owner.getX();
        float ownerRight = owner.getX() + owner.getWidth();
        boolean outsideTop;
        boolean outsideBottom;
        boolean outsideLeft;
        boolean outsideRight;

        for (Entity entity : entities) {

            if (!owner.equals(entity)) {
                outsideTop = (ownerTop > entity.getY() + entity.getHeight());
                outsideBottom = (ownerBottom < entity.getY());
                outsideLeft = (ownerLeft > entity.getX() + entity.getWidth());
                outsideRight = (ownerRight < entity.getX());

                if ( !(outsideTop || outsideBottom ||
                        outsideLeft || outsideRight)) {
                    return entity;
                }
            }
        }

        return null;
    }

}
