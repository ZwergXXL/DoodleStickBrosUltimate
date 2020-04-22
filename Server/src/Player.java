import character.BetaBoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread{

    final Socket socket;
    final int key;

    BufferedReader in;
    PrintWriter out;

    BetaBoy betaBoy;

    Player(Socket socket, int key){
        this.socket = socket;
        this.key = key;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }



        betaBoy = new BetaBoy();
    }

    @Override
    public void run() {
        inMenu();
    }

    void inMenu(){
        String input;
        try {
            while (true) {
                input = in.readLine();
                if(input != null){

                    switch (input){
                        case "idk":
                            break;
                        default: System.out.println("Menu Input nicht vorhanden: " + input);
                    }


                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    void getInputData(){
        try {
            String[] input  = in.readLine().split("_");  // Movement Jump Ability

            switch (input[0]){
                case "A":
                    break;
                case "S":
                    break;
                case "D":
                    break;
                case "/":
                    break;
            }

            switch (input[1]){
                case "W":
                    break;
                case "/":
                    break;
            }

            switch (input[2]){
                case "Q":
                    break;
                case "":
                    break;
                case "D":
                    break;
                case "/":
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
