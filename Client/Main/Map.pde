public class Map {

  Map() {
  }

  void updateMap(int[][] map) {
    fill(0);
    for (int x = 0; x < 128; x++) {
      for (int y = 0; y < 72; y++) {

        if (map[x][y] == 1) {
          println("yeah");
          square(x * 15, y * 15, 15);
        }
      }
    }
  }


  void updateEntities(ArrayList<Entity> entities) {
    Entity entity;
    for (int i = 0; i < entities.size(); i++) {
      entity = entities.get(i);
      switch(entity.id) {
      case 0: 
        fill(0);

      default: 
        fill(#E32FF7);
      }
      rect(entity.x * 15, entity.y * 15, entity.length * 15, entity.height * 15);
    }
  }

  void updateEntities(String entityString) {
    String[] allEntities = entityString.split(";");
    
    String[] entityData;
      for (String entity : allEntities) {
        entityData = entity.split(",");
        fill(#E32FF7);
        println(Integer.parseInt(entityData[0]) + " " + Integer.parseInt(entityData[1]));
        rect(Integer.parseInt(entityData[0]) * 15, Integer.parseInt(entityData[1]) * 15, 2 * 15, 6 * 15);
    }
  }
}
