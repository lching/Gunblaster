package com.gunblaster.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.gunblaster.state.GameplayState;

public class GunblasterGame extends StateBasedGame {

    public static final int MAINMENUSTATE = 0;
    public static final int GAMEPLAYSTATE = 1;

    public GunblasterGame() {
        super("Gunblaster");
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new GameplayState(GAMEPLAYSTATE));
    }

    public static void main(String args[]) throws SlickException {
        AppGameContainer app = new AppGameContainer(new GunblasterGame());

        app.setDisplayMode(800, 600, false);
        app.setTargetFrameRate(60);
        app.start();
    }

}