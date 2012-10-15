package com.gunblaster.component.custom;

import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.component.Component;
import com.gunblaster.entity.Entity;
import com.gunblaster.entity.model.Bullet;
import com.gunblaster.entity.model.Player;

public class FireBullet extends Component {

    private List<Bullet> bullets;

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        Input input = container.getInput();
        Player player = (Player) owner;
        Bullet bullet = player.getBullet();
        Vector2f position = bullet.getPosition();
        float speed = bullet.getSpeed();

        if (input.isKeyPressed(Input.KEY_SPACE)) {
            bullet.setFired(true);
            position = new Vector2f(player.getPosition());
        }

        if (bullet.isFired()) {
            position.y -= speed * delta;
            player.getBullet().setPosition(position);
            owner = player;
        }

    }

}