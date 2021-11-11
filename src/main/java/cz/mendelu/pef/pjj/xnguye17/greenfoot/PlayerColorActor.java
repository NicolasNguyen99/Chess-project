package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Player;
import greenfoot.Actor;

public class PlayerColorActor extends Actor {
    Player player;
    public PlayerColorActor(Player player) {
        this.player = player;
        setImage(String.format("images/playerColors/%s.png", player.getPieceColor()));
    }
}
