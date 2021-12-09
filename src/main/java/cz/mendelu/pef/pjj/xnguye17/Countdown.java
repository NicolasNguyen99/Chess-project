package cz.mendelu.pef.pjj.xnguye17;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {

    public Countdown(Player player) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if(player.getPieceColor() == Board.getPlayerRound()) {
                    player.lowerRemainingTime();
                } else {
                    this.cancel();
                }
                if (player.getRemainingTime() <= 0) {
                    this.cancel();
                    Board.checkEndGame();
                }
            }
        }, 0, 1000);
    }
}
