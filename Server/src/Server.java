import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {

    ServerSocket serverSocket;
    ArrayList<Player> playerList;

    public static void main(String[] args) {
        new Server().start();
    }

    Server(){
        try {
            playerList = new ArrayList<>();
            serverSocket = new ServerSocket(12345);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                addPlayer();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addPlayer() throws IOException {
        Socket socket = serverSocket.accept();
        Player newPlayer = new Player(socket, playerList.size());
        newPlayer.start();
        playerList.add(newPlayer);

        System.out.println("New Player Connected!");
    }
}
