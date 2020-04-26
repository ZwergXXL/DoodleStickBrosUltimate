public class Map {

  Map() {
  }

  void updateMap(int[][] map) {
    fill(0);
    for (int x = 0; x < 128; x++) {
      for (int y = 0; y < 72; y++) {
        if (map[x][y] == 1) {

          square(x * 15, y * 15, 15);
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
      rect(Integer.parseInt(entityData[0]) * 15, Integer.parseInt(entityData[1]) * 15, 2 * 15, 6 * 15);
    } 
  }
}
