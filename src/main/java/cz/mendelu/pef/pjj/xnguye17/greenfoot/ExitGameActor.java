package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Game;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

/**
 * (greenfoot) trida k ukonceni hry.
 *
 * @author xnguye17
 * @version etapa 4
 */
public class ExitGameActor extends Actor {
    private final Game game;

    public ExitGameActor(Game game) {
        this.game = game;
        var image = new GreenfootImage("Exit game", 24, Color.BLACK, new Color(0,0,0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            game.endGame();
        }
    }
}
