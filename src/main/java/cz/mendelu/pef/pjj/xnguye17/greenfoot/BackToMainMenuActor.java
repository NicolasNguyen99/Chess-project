package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.greenfoot.worlds.StartingMenuWorld;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class BackToMainMenuActor extends Actor {
    public BackToMainMenuActor() {
        var image = new GreenfootImage("Back", 24, Color.BLACK, new Color(0,0,0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            StartingMenuWorld startingMenuWorld = new StartingMenuWorld();
            Greenfoot.setWorld(startingMenuWorld);
        }
    }
}
