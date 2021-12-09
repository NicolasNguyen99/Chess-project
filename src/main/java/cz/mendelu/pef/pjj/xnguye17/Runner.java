package cz.mendelu.pef.pjj.xnguye17;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pef.pjj.xnguye17.LAN.Lan;
import cz.mendelu.pef.pjj.xnguye17.greenfoot.worlds.StartingMenuWorld;

public class Runner extends GreenfootRunner {
    public static void main(String[] args) {
        bootstrap(Runner.class,
                Configuration.forWorld(StartingMenuWorld.class)
                        .projectName("Chess")
                        .hideControls(true)
        );
        GreenfootRunner.main(args);
    }
}
