package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Player;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class LabelActor extends Actor {
    private Player player;

    public LabelActor(Player player) {
        this.player = player;
    }

    @Override
    public void act() {
        var image = new GreenfootImage(player.getName(), 24, Color.BLACK, new Color(0,0,0, 0));
        setImage(image);
    }
}
