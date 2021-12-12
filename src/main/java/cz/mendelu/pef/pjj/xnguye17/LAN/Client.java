package cz.mendelu.pef.pjj.xnguye17.LAN;

import cz.mendelu.pef.pjj.xnguye17.Game;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Client {
    private final Game game;
    private final int port;

    public Client(Game game) {
        this.game = game;
        this.port = (Lan.getServer().getPort() == 4000) ? 4001 : 4000;
    }

    public void send() {
        try {
            var s = new Socket("127.0.0.1", port);
            try (var dout = new DataOutputStream(s.getOutputStream())) {
                dout.writeUTF(Files.readString(Path.of("texts/" + game.getGamename())));
                dout.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
