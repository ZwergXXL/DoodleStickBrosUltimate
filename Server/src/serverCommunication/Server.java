package serverCommunication;

import game.GameEngine;
import game.fighter.BetaBoy;
import game.fighter.Fighter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    ServerSocket serverSocket;
    ArrayList<Player> playerList;
    ArrayList<GameEngine> games;

    ArrayList<Player> lobby;
    public static Server server = new Server();

    public static void main(String[] args)
    {

    }

    private Server(){
        try {
            playerList = new ArrayList<>();
            games = new ArrayList<>();
            lobby = new ArrayList<>();
            serverSocket = new ServerSocket(12345);

        } catch (IOException e) {
            e.printStackTrace();
        }

        run();
    }

    public void run() {
        try {
            while (true) {
                addPlayer();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void addPlayer() throws IOException {
        Socket socket = serverSocket.accept();
        Player newPlayer = new Player(socket, playerList.size(), this);
        newPlayer.start();
        playerList.add(newPlayer);

        System.out.println("New Player Connected!");
    }

    public void joinLobby(Player player){
        if (lobby.contains(player)){
            return;
        }
        lobby.add(player);
        GameEngine gameEngine = new GameEngine(lobby);
    }












    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<GameEngine> getGames() {
        return games;
    }

    public void setGames(ArrayList<GameEngine> games) {
        this.games = games;
    }

    public ArrayList<Player> getLobby() {
        return lobby;
    }

    public void setLobby(ArrayList<Player> lobby) {
        this.lobby = lobby;
    }
}
