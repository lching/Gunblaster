package com.gunblaster.component.custom;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.component.Component;
import com.gunblaster.entity.model.Bullet;

public class FireBullet extends Component {

    private List<Bullet> bullets;
    private Bullet removable;
    private Image image;;

    public FireBullet(String id, Bullet bullet) {
        this.id = id;
        bullets = new ArrayList<Bullet>();
    }

    @Override
    public void init() {
        try {
            image = new Image("data/images/bullet.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        Input input = container.getInput();

        if (input.isKeyPressed(Input.KEY_SPACE)) {
            Bullet bullet = new Bullet();
            bullet.setOwner(this.owner);
            bullet.setPosition(new Vector2f(owner.getPosition()));
            bullet.setSpeed(1.0f);
            bullet.setImage(image);
            bullet.setFired(true);
            bullets.add(bullet);

            for (Bullet b : bullets) {
                owner.getWorld().addEntity(b);
            }
        }

        for (Bullet bullet : bullets) {
            if (bullet.isFired()) {
                bullet.getPosition().y -= bullet.getSpeed() * delta;
            }

            if (bullet.getPosition().getY() < 0) {
                removable = bullet;
            }
        }

        owner.getWorld().removeEntity(removable);
        bullets.remove(removable);
    }

}