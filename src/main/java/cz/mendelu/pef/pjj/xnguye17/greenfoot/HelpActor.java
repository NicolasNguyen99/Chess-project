package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.greenfoot.worlds.HelpWorld;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class HelpActor extends Actor {
    public HelpActor() {
        var image = new GreenfootImage("How to play", 24, Color.BLACK, new Color(0,0,0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            HelpWorld helpWorld = new HelpWorld();
            Greenfoot.setWorld(helpWorld);
        }
    }
}
