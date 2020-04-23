public class Map {

  int[][] map = new int[128][72];


  Map() {
    for (int x = 0; x < 128; x++) {
      for (int y = 0; y < 72; y++) {    
        map[x][y] = 0;
      }
    }
    map[0][0] = -1;
    map[15][15] = -1;
    map[127][71] = -1;
    updateMap();
  }

  void updateMap() {
    fill(0);
    for (int x = 0; x < 128; x++) {
      for (int y = 0; y < 72; y++) {

        if (map[x][y] == -1) {
          square(x * 15, y * 15, 15);
        }
      }
    }
  }
}
