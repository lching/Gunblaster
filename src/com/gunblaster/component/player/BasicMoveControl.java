package com.gunblaster.component.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.component.Component;

public class BasicMoveControl extends Component {

    public static final String ID = "BasicMoveControl";
    private int upKey;
    private int downKey;
    private int leftKey;
    private int rightKey;

    public BasicMoveControl(int upKey, int downKey, int leftKey, int rightKey) {
        this.id = ID;
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey =rightKey;
    }

    public int getUpKey() {
        return upKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public int getLeftKey() {
        return leftKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        Vector2f position = owner.getPosition();
        float speed = owner.getSpeed();
        Input input = container.getInput();

        if ( input.isKeyDown(downKey) ) {
            position.y += speed * delta;
        }

        if ( input.isKeyDown(upKey) ) {
            position.y -= speed * delta;
        }

        if ( input.isKeyDown(rightKey) ) {
            position.x += speed * delta;
        }

        if ( input.isKeyDown(leftKey) ) {
            position.x -= speed * delta;
        }

    }

}
