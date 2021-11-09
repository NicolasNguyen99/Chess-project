package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class TimerActor extends Actor {
    private int time;

    public TimerActor() {
        this.time = 3300;
        Greenfoot.setSpeed(18);
    }

    private String calculateTime(int time) {
        int minutes = time/60;
        int seconds = time - (minutes*60);
        return minutes + " : " + (seconds/10 == 0 ? "0" + seconds : seconds);
    }

    @Override
    public void act() {
        time--;
        var image = new GreenfootImage(calculateTime(time), 24, Color.BLACK, new Color(0,0,0, 0));
        setImage(image);
    }
}
