ServerConnection serverConnection;
Map map;

int counter;
boolean[] keysPressed;


void setup() {
  size(1920, 1080); 
  background(255);

  keysPressed = new boolean[5]; // W A S D Space
  for (int i = 0; i < keysPressed.length; i++) {
    keysPressed[i] = false;
  }

  serverConnection = new ServerConnection(this);
  map = new Map();
  counter = 0;
  println("starting...");
}

void draw() {
  counter++;
  println("----------------- NEW TICK: " + counter + "--------------");
  background(255);
  try {
    serverConnection.sendUserInput();

    map.updateMap(serverConnection.readMap());
    map.updateEntities(serverConnection.readEntityString());
  }
  catch(Exception e) {
    e.printStackTrace();
  }
}






void keyPressed() {
  switch(keyCode) {
  case 87: 
    keysPressed[0] = true; //W
    break;
  case 65: 
    keysPressed[1] = true; //A
    break;
  case 83: 
    keysPressed[2] = true; //S
    break;
  case 68: 
    keysPressed[3] = true; //D
    break;
  case 32: 
    keysPressed[4] = true; //Space
    break;
  default: 
    println(keyCode);
  }
}



void keyReleased() {
  switch(keyCode) {
  case 87: 
    keysPressed[0] = false; //W
    break;
  case 65: 
    keysPressed[1] = false; //A
    break;
  case 83: 
    keysPressed[2] = false; //S
    break;
  case 68: 
    keysPressed[3] = false; //D
    break;
  case 32: 
    keysPressed[4] = false; //Space
    break;
  default: 
    println(keyCode);
  }
}


boolean[] getKeysPressed() {
  return keysPressed;
}
