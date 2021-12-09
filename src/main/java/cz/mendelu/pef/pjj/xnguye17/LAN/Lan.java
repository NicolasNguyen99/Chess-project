package cz.mendelu.pef.pjj.xnguye17.LAN;

import cz.mendelu.pef.pjj.xnguye17.Game;

public class Lan {
    private static Server server = null;
    private static Client client = null;

    public static void newLan(Game game) {
        if(server == null && client == null){
            server = new Server(game);
            client = new Client(game);
        }
    }

    public static Server getServer() {
        return server;
    }

    public static Client getClient() {
        return client;
    }
}
