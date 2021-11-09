package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Color;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class SquareActor extends Actor {
    private Color color;
    private int row;
    private int col;

    public SquareActor(Color color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
        var image = new GreenfootImage(String.format("images/squares/%s.png", color));
        setImage(image);
    }
}
