ClientInput clientInput;
ServerConnection serverConnection;
Map map;



void setup() {
  fullScreen();
  //size(1920,1080); 
  background(255);

  clientInput = new ClientInput();
  serverConnection = new ServerConnection(clientInput);
  map = new Map();
}

void draw() {
  try {
    serverConnection.sendUserInput();
    
    map.updateMap(serverConnection.readMap());
    map.updateEntities(serverConnection.readEntityString());
  }
  catch(Exception e) {
    e.printStackTrace();
  }
}





void keyTyped() {
  switch(keyCode) {
  case 87: 
    clientInput.keysPressed[0] = true; //W
    break;
  case 65: 
    clientInput.keysPressed[1] = true; //A
    break;
  case 83: 
    clientInput.keysPressed[2] = true; //S
    break;
  case 68: 
    clientInput.keysPressed[3] = true; //D
    break;
  case 32: 
    clientInput.keysPressed[4] = true; //Space
    break;
  default: 
    println(keyCode);
  }
}

void keyReleased() {
  switch(keyCode) {
  case 87: 
    clientInput.keysPressed[0] = false; //W
    break;
  case 65: 
    clientInput.keysPressed[1] = false; //A
    break;
  case 83: 
    clientInput.keysPressed[2] = false; //S
    break;
  case 68: 
    clientInput.keysPressed[3] = false; //D
    break;
  case 32: 
    clientInput.keysPressed[4] = false; //Space
    break;
  default: 
    println(keyCode);
  }
}
