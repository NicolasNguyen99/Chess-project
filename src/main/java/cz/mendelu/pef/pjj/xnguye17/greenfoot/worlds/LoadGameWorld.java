package cz.mendelu.pef.pjj.xnguye17.greenfoot.worlds;

import cz.mendelu.pef.pjj.xnguye17.greenfoot.BackToMainMenuActor;
import cz.mendelu.pef.pjj.xnguye17.greenfoot.LoadOptionActor;
import greenfoot.World;

import java.io.File;

public class LoadGameWorld extends World {
    public LoadGameWorld () {
        super(11, 8, 75);
        setBackground("images/menu/menuBackground.png");
        var savedGames = new File("texts").list((dir, name) -> name.matches("^.*\\.txt"));
        if (savedGames != null) {
            int x = 5;
            int y = 0;
            for (var savedGame : savedGames) {
                if (y != 6) y ++;
                    else {
                        y = 1;
                        x += 2;
                }
                addObject(new LoadOptionActor(savedGame), x, y);
            }
        }
        addObject(new BackToMainMenuActor(), 9, 7);
    }
}
