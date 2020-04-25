public class Map {

  Map() {
  }

  void updateMap(int[][] map) {
    fill(0);
    for (int x = 0; x < 128; x++) {
      for (int y = 0; y < 72; y++) {

        if (map[x][y] == -1) {
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
}
