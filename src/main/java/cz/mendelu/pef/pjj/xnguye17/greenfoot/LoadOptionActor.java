package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.greenfoot.worlds.ChessWorld;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;


public class LoadOptionActor extends Actor {
    private final String nameOfSave;

    public LoadOptionActor(String nameOfSave) {
        this.nameOfSave = nameOfSave;
        var image = new GreenfootImage(nameOfSave, 24, Color.BLACK, new Color(0,0,0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            ChessWorld chessWorld = new ChessWorld(nameOfSave);
            Greenfoot.setWorld(chessWorld);
        }
    }

}
