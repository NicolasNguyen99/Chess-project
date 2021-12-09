package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Player;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

/**
 * (greenfoot) trida zobrazujici zbyvajici cas hrace.
 *
 * @author xnguye17
 * @version etapa 4
 */
public class TimerActor extends Actor {
    private final Player player;

    public TimerActor(Player player) {
        this.player = player;
        var image = new GreenfootImage(calculateTime(player.getRemainingTime()), 24, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (player.getPieceColor() == Board.getPlayerRound()) {
            var image = new GreenfootImage(calculateTime(player.getRemainingTime()), 24, Color.BLACK, new Color(0, 0, 0, 0));
            setImage(image);
        }
    }

    private String calculateTime(int time) {
        int minutes = time/60;
        int seconds = time - (minutes*60);
        return minutes + " : " + (seconds/10 == 0 ? "0" + seconds : seconds);
    }
}
