package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.Game;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class SurrenderActor extends Actor {
    private Game game;
    public SurrenderActor(Game game) {
        this.game = game;
        var image = new GreenfootImage("Surrender", 24, java.awt.Color.BLACK, new java.awt.Color(0,0,0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (Board.getPlayerRound() == Color.WHITE)
                game.getPlayers()[0].wantSurrender();
            else
                game.getPlayers()[1].wantSurrender();
            Board.checkEndGame();
        }
    }
}
