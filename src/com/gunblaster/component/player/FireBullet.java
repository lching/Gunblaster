package com.gunblaster.component.player;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.component.Component;
import com.gunblaster.entity.model.Bullet;

public class FireBullet extends Component {

    public static final String ID = "FireBullet";
    private List<Bullet> bullets;
    private Bullet bullet;
    private int fireKey;
    private int timer;

    public FireBullet(int fireKey, Bullet bullet) {
        id = ID;
        bullets = new ArrayList<Bullet>();
        this.bullet = bullet;
        this.fireKey = fireKey;
        timer = bullet.getTimer();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        Input input = container.getInput();
        Bullet removable = null;

        if (timer <= bullet.getTimer()) {
            timer += delta;
        } 

        if (input.isKeyPressed(fireKey) || input.isKeyDown(fireKey)) {
            if (timer/bullet.getTimer() == 1) {
                Bullet bullet = new Bullet(this.bullet);
                bullet.setPosition(new Vector2f(owner.getPosition()));
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