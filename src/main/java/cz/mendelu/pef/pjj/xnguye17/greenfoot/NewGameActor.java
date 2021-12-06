package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class NewGameActor extends Actor {
    public NewGameActor() {
        var image = new GreenfootImage("New Game", 24, Color.BLACK, new Color(0,0,0, 0));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            var gameName = Greenfoot.ask("Enter your game name:")+".txt";
            var savedGames = new File("texts").list();
            while (savedGames != null && Arrays.asList(savedGames).contains(gameName)) {
                gameName = Greenfoot.ask(gameName + " is already taken, enter different game name:");
            }
            ChessWorld chessWorld = new ChessWorld(gameName);
            Greenfoot.setWorld(chessWorld);
        }
    }
}
