import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.*;

public class ServerConnection {

  Socket socket;
  ObjectInputStream in;
  ObjectOutputStream out;
  ClientInput clientInput;

  ServerConnection(ClientInput clientInput) {
    try {
      this.socket = new Socket("127.0.0.1", 12345);
      this.clientInput = clientInput;

      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream((socket.getInputStream()));
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }



  // Sends Userinput to Server
  void sendUserInput() throws IOException, ClassNotFoundException {
    String request = (String) in.readObject();
    if (request != "sendInput") {
      sendUserInput();
      delay(1);
    }

    boolean[] userInputs = clientInput.keysPressed;
    String[] input = new String[3];
    for (int i = 0; i < input.length; i++) {
      input[i] = "/";
    }

    //checks for jump
    if (userInputs[4]) { //Space
      input[1] = "jump";
    }

    // w a s d
    if (userInputs[2]) { //S
      input[0] = "00";
    } else if (userInputs[0]) { //W
      input[0] = "11";
    } else if (!(userInputs[1]&&userInputs[3])) { //!(A & D)
      if (userInputs[1]) {
        input[0] = "10";
      }
      if (userInputs[3]) {
        input[0] = "01";
      }
    }

    try {
      out.writeObject(new String(input[0] + "_" + input[1] + "_" + input[2]));
    }
    catch(IOException e) {
    }
  }

  int[][] readMap() throws IOException, ClassNotFoundException {
    Object data = in.readObject();
    if (data.getClass().getName() == "[[I") {
      return (int[][]) data;
    }
    delay(1);
    return readMap();
  }

  
  /*
   ArrayList<Entity> readEntityList() throws IOException, ClassNotFoundException {
   Object data = in.readObject();
   if (data.getClass().getName() == "Idk???") {
   return (ArrayList<Entity>) data;
   }
   delay(1);
   return readEntityList();
   }
   */
   
   String readEntityString() throws IOException, ClassNotFoundException {
   String data = (String)in.readObject();
   if(data != null){
     return data;
   }
   delay(1);
   return readEntityString();
   }
   


  void disconnect() {
    try {
      socket.close();
    }
    catch(IOException e) {
    }
  }
}
