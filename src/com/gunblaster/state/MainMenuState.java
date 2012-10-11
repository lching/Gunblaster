package com.gunblaster.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

    private int id = -1;

    public MainMenuState(int id) {
        this.id = id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        
    }

    @Override
    public int getID() {
        return id;
    }

}