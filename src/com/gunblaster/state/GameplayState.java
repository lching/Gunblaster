package com.gunblaster.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.collision.impl.BoundingBox;
import com.gunblaster.component.custom.ControlMovement;
import com.gunblaster.component.custom.FireBullet;
import com.gunblaster.entity.model.Bullet;
import com.gunblaster.entity.model.Player;
import com.gunblaster.world.World;

public class GameplayState extends BasicGameState {

    private int id = -1;
    private World world = null;
    private Player player = null;

    public GameplayState(int id) {
        this.id = id;
    }

    /*
     * Slick BasicGameState methods.
     */
    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        player = new Player("PLAYER");
        world = new World("Level 1");

        player.setSpeed(0.2f);
        player.setPosition(new Vector2f(385, 520));
        player.setHitDetection(new BoundingBox());
        player.setBullet(new Bullet("Player Bullet"));
        player.addComponent(new ControlMovement("PLAYER_MOVEMENT"));
        player.addComponent(new FireBullet());

        world.addEntity(player);
        world.addEntity(player.getBullet());
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        world.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        world.update(container, game, delta);
    }

}