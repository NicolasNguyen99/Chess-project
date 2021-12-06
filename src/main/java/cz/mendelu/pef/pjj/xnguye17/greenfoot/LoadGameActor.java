package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.awt.*;

public class LoadGameActor extends Actor {
    public LoadGameActor() {
        var image = new GreenfootImage("Load game", 24, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            LoadGameWorld loadGameWorld = new LoadGameWorld();
            Greenfoot.setWorld(loadGameWorld);
        }
    }
}
