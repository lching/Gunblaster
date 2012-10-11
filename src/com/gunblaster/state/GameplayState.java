package com.gunblaster.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.component.custom.ControlMovement;
import com.gunblaster.entity.model.Player;
import com.gunblaster.entity.model.Wall;
import com.gunblaster.world.World;

public class GameplayState extends BasicGameState {

    private int id = -1;
    private World world = null;
    private Player player = null;
    private Wall wall = null;

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
        wall = new Wall("WALL");
        world = new World("Level 1");

        player.setSpeed(0.2f);
        player.setPosition(new Vector2f(385, 550));
        player.addComponent(new ControlMovement("PLAYER_MOVEMENT"));

        world.addEntity(player);
        world.addEntity(wall);
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