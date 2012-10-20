package com.gunblaster.ship;

import java.util.Map;

import org.newdawn.slick.Animation;

public interface Ship {

    public static String LEFT = "LEFT";
    public static String RIGHT = "RIGHTT";
    public static String DEFAULT = "DEFAULT";
    public static String DEAD = "DEAD";

    public Map<String, Animation> getAnimations();

}
