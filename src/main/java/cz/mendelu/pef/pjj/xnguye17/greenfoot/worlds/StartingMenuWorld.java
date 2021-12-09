package cz.mendelu.pef.pjj.xnguye17.greenfoot.worlds;

import cz.mendelu.pef.pjj.xnguye17.Game;
import cz.mendelu.pef.pjj.xnguye17.greenfoot.ExitGameActor;
import cz.mendelu.pef.pjj.xnguye17.greenfoot.HelpActor;
import cz.mendelu.pef.pjj.xnguye17.greenfoot.LoadGameActor;
import cz.mendelu.pef.pjj.xnguye17.greenfoot.NewGameActor;
import greenfoot.World;

public class StartingMenuWorld extends World {
    public StartingMenuWorld () {
        super(825, 600, 1);
        setBackground("images/menu/mainMenuBackground.png");

        addObject(new NewGameActor(), 412, 400);
        addObject(new LoadGameActor(), 412, 440);
        addObject(new HelpActor(), 412, 480);
        addObject(new ExitGameActor(), 412, 520);
    }
}
