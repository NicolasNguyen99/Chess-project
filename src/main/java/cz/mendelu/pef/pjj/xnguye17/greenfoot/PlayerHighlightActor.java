package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Game;
import cz.mendelu.pef.pjj.xnguye17.Player;
import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * (greenfoot) trida zvyraznujici hrace, ktery je na tahu.
 *
 * @author xnguye17
 * @version etapa 4
 */
public class PlayerHighlightActor extends Actor {
    private final Player player;

    public PlayerHighlightActor(Player player) {
        this.player = player;
        setImage("images/playerColors/highlight.png");
    }

    public void act() {
        if (player.getPieceColor() != Board.getPlayerRound()) {
            getWorld().removeObject(this);
        }
    }
}
