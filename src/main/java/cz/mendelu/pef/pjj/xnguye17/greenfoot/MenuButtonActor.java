package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Game;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

/**
 * (greenfoot) trida zobrazujici herni menu.
 *
 * @author xnguye17
 * @version etapa 4
 */
public class MenuButtonActor extends Actor {
    private final Game game;

    public MenuButtonActor(Game game) {
        this.game = game;
        var image = new GreenfootImage("Menu", 24, Color.BLACK, new Color(0,0,0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            getWorld().addObject(new MenuActor(game), 9, 4);
        }
    }
}

