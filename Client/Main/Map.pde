public class Map {
  
  int blockSize = 8;
  PImage yeaah;
  
  Map() {
    yeaah = loadImage("test.jpg");
  }

  void updateMap(int[][] map) {
      fill(0);
      for (int y = 0; y < height/blockSize; y++) {
        for (int x = 0; x < width/blockSize; x++) {
          if (map[x][y] == 1) {
            square(x * blockSize, y * blockSize, blockSize);
          }
          
      }
    }
  }

  void updateEntities(String entityString) {
    String[] allEntities = entityString.split(";");
    println(allEntities.length);

    String[] entityData;
    for (String entity : allEntities) {
      entityData = entity.split(",");
      fill(#E32FF7);
      // println(Integer.parseInt(entityData[0]) + " " + Integer.parseInt(entityData[1]));
      //rect(Integer.parseInt(entityData[0]) * blockSize, Integer.parseInt(entityData[1]) * blockSize, 4 * blockSize, 10 * blockSize);
      image(yeaah, Integer.parseInt(entityData[0]) * blockSize, Integer.parseInt(entityData[1]) * blockSize);
    } 
  }
}
