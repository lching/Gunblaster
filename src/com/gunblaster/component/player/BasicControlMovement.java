package com.gunblaster.component.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.component.Component;
import com.gunblaster.entity.model.Player;

public class BasicControlMovement extends Component {

    public BasicControlMovement(String id) {
        this.id = id;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        Player player = (Player) owner;
        Vector2f position = owner.getPosition();
        float speed = owner.getSpeed();
        Input input = container.getInput();

        //Logic for controls
        if ( input.isKeyDown(player.getKeyDown()) ) {
            position.y += speed * delta;
        }

        if ( input.isKeyDown(player.getKeyUp()) ) {
            position.y -= speed * delta;
        }

        if ( input.isKeyDown(player.getKeyRight()) ) {
            position.x += speed * delta;
        }

        if ( input.isKeyDown(player.getKeyLeft()) ) {
            position.x -= speed * delta;
        }

        owner.setPosition(position);
    }

}
