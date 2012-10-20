package com.gunblaster.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.component.player.BasicMoveControl;
import com.gunblaster.component.player.FireBullet;
import com.gunblaster.entity.model.Bullet;
import com.gunblaster.entity.model.Player;
import com.gunblaster.logger.Logger;
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
        player = new Player(385, 520);
        Bullet bullet = new Bullet(300, 1.0f);
        //Wall wall = new Wall(300, 400);
        world = new World("Level 1", container.getWidth(), container.getHeight());

        bullet.setImage(new Image("data/images/bullet.png"));

        //wall.setImage(new Image("data/images/border.png"));

        player.addComponent(new BasicMoveControl(Input.KEY_UP, Input.KEY_DOWN, Input.KEY_LEFT, Input.KEY_RIGHT));
        player.addComponent(new FireBullet(Input.KEY_SPACE, bullet));

        world.addEntity(player);
        //world.addEntity(wall);
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
        Logger.log("Size => " + world.getEntities().size());
    }

}