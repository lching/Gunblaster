package com.gunblaster.component.custom;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.component.Component;
import com.gunblaster.entity.Entity;

public class ControlMovement extends Component {

    public ControlMovement(String id) {
        this.id = id;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        Vector2f position = owner.getPosition();
        float speed = owner.getSpeed();
        Input input = container.getInput();

        //Logic for controls
        if (input.isKeyDown(Input.KEY_DOWN)) {
            position.y += speed * delta;
            if (owner.getCollision().collide(Entity.SOLID) != null) {
                position.y -= speed * delta;
            }
        }
        if (input.isKeyDown(Input.KEY_UP)) {
            position.y -= speed * delta;
            if (owner.getCollision().collide(Entity.SOLID) != null) {
                position.y += speed * delta;
            }
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            position.x += speed * delta;
            if (owner.getCollision().collide(Entity.SOLID) != null) {
                position.x -= speed * delta;
            }
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            position.x -= speed * delta;
            if (owner.getCollision().collide(Entity.SOLID) != null) {
                position.x += speed * delta;
            }
        }

        owner.setPosition(position);
    }

}
