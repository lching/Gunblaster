package com.gunblaster.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import com.gunblaster.collision.BoundingBox;
import com.gunblaster.component.custom.ControlMovement;
import com.gunblaster.entity.model.Border;
import com.gunblaster.entity.model.Player;
import com.gunblaster.world.World;

public class GameplayState extends BasicGameState {

    private int id = -1;
    private World world = null;
    private Player player = null;
    private TiledMap borderMap; 

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
        borderMap = new TiledMap("data/maps/border.tmx");

        player.setSpeed(0.2f);
        player.setPosition(new Vector2f(385, 520));
        player.addComponent(new ControlMovement("PLAYER_MOVEMENT"));
        player.setCollision(new BoundingBox());

        for (int x = 0; x < borderMap.getWidth(); x++) {
            for (int y = 0; y < borderMap.getHeight(); y++) {
                int tileId = borderMap.getTileId(x, y, 0);
                String value = borderMap.getTileProperty(tileId, "border", "false");
                if (value.equalsIgnoreCase("true")) {
                    Border border = new Border("BORDER");
                    border.setPosition(new Vector2f(x*border.getWidth(), y*border.getHeight()));
                    world.addEntity(border);
                }
            }
        }

        world.addEntity(player);
        System.out.println(world.getEntities().size());
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