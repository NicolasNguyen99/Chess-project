package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import greenfoot.World;

import java.io.File;

public class LoadGameWorld extends World {
    public LoadGameWorld () {
        super(11, 8, 75);
        var savedGames = new File("texts").list();
        if (savedGames != null) {
            int x = 5;
            int y = 0;
            for (var savedGame : savedGames) {
                y ++;
                addObject(new LoadOptionActor(savedGame), x, y);
            }
        }
    }
}
