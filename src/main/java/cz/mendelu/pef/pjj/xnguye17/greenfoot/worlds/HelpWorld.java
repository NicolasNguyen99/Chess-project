package cz.mendelu.pef.pjj.xnguye17.greenfoot.worlds;

import cz.mendelu.pef.pjj.xnguye17.greenfoot.BackToMainMenuActor;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HelpWorld extends World {
    public HelpWorld() {
        super(11, 8, 75);
        setBackground("images/menu/menuBackground.png");
        addObject(new Actor() {
            String content;
            {
                try {
                    content = Files.readString(Path.of("texts/conf/help.txt"));
                    var image = new GreenfootImage(content, 21, Color.black, new Color(0, 0, 0, 0));
                    setImage(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 5, 3);

        addObject(new BackToMainMenuActor(), 9, 7);
    }
}
