package com.gunblaster.component.custom;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.component.Component;
import com.gunblaster.entity.model.Bullet;

public class FireBullet extends Component {

    private List<Bullet> bullets;
    private Bullet bullet;
    private Bullet removable;
    private int timer;

    public FireBullet(String id, Bullet bullet) {
        this.id = id;
        bullets = new ArrayList<Bullet>();
        this.bullet = bullet;
        timer = bullet.getTimer();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        Input input = container.getInput();

        if (timer <= bullet.getTimer()) {
            timer += delta;
        } 

        if (input.isKeyPressed(Input.KEY_SPACE) || input.isKeyDown(Input.KEY_SPACE)) {
            if (timer/bullet.getTimer() == 1) {
                Bullet bullet = new Bullet();
                bullet.setPosition(new Vector2f(owner.getPosition()));
                bullet.setSpeed(this.bullet.getSpeed());
                bullet.setImage(this.bullet.getImage());
                bullet.setFired(true);
                bullets.add(bullet);

                owner.getWorld().addEntity(bullet);
                timer = 0;
            }
        }

        for (Bullet bullet : bullets) {
            if (bullet.isFired()) {
                bullet.getPosition().y -= bullet.getSpeed() * delta;
            }

            if (bullet.getPosition().getY() < 0) {
                removable = bullet;
                removable.destroy();
            }
        }

        bullets.remove(removable);
    }

}