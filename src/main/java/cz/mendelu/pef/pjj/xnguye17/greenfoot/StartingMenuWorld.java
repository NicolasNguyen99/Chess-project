package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Game;
import greenfoot.World;

public class StartingMenuWorld extends World {
    public StartingMenuWorld () {
        super(825, 600, 1);
//        setBackground("images/board.png");

        addObject(new NewGameActor(), 412, 200);
        addObject(new LoadGameActor(), 412, 300);
        addObject(new ExitGameActor(new Game("")), 412, 400);
    }
}
