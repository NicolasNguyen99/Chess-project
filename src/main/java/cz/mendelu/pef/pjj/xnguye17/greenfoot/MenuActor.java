package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Game;
import greenfoot.Actor;

/**
 * (greenfoot) trida zobrazujici herni menu.
 * TODO toggle mode
 *
 * @author xnguye17
 * @version etapa 4
 */
public class MenuActor extends Actor {
    private final Game game;
    private boolean isDisplayed;

    public MenuActor(Game game) {
        this.game = game;
        this.isDisplayed = false;
        setImage("images/menu/background.png");
    }

    public void act() {
        if (!isDisplayed) {
            getWorld().addObject(new SaveGameActor(game), 9, 4);
            getWorld().addObject(new ExitGameActor(game), 9, 5);
            isDisplayed = true;
        }
    }
}
