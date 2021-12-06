package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Game;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

/**
 * (greenfoot) trida ukladajici hru do souboru.
 *
 * @author xnguye17
 * @version etapa 4
 */
public class SaveGameActor extends Actor {
    private final Game game;

    public SaveGameActor(Game game) {
        this.game = game;
        var image = new GreenfootImage("Save game", 24, Color.BLACK, new Color(0,0,0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this))
            game.saveGame();
    }
}
