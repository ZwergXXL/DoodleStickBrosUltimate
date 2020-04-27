public class Map {
  
  int blockSize = 10;
  
  Map() {
  }

  void updateMap(int[][] map) {
      fill(0);
      for (int y = 0; y < 144; y++) {
        for (int x = 0; x < 256; x++) {
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
      println(Integer.parseInt(entityData[0]) + " " + Integer.parseInt(entityData[1]));
      rect(Integer.parseInt(entityData[0]) * blockSize, Integer.parseInt(entityData[1]) * blockSize, 2 * blockSize, 6 * blockSize);
    } 
  }
}
