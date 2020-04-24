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
  
  
  void updateMap(String data) {
    String[] dataSet = data.split("_");
    String[] mapBlocks = dataSet[0].split(";");
    
    fill(0)
    String[] blockData;
    for (int i = 0; i < mapBlocks.length; i++) {
      blockData =  mapBlocks[i].split(",");
      rect(Integer.parseInt(blockData[0]) * 15, Integer.parseInt(blockData[1]) * 15, Integer.parseInt(blockData[2]) * 15 ,15);
    }
               
  }
}
