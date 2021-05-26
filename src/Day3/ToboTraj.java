import java.util.ArrayList;

public class ToboTraj {

    public static char[][] generateMap(ArrayList mapData) {
        int mapHeight = mapData.size();
        int mapLength = 3 * mapHeight;
        int currentChar = 0;
        char[][] createdMap = new char[mapHeight][mapLength];

        for(int x = 0; x < mapHeight; x++) {
            for(int y = 0; y < mapLength; y++) {
                if(currentChar >= mapData.get(0).toString().length()) {
                    currentChar = 0;
                }
                createdMap[x][y] = mapData.get(x).toString().charAt(currentChar);
                currentChar++;
            }
            currentChar = 0;
        }
        return createdMap;
    }

    public static void main(String[] args) {
        parseData inputData = new parseData();
        ArrayList<String> mapData = inputData.readInput();

        char[][] expandedMap = generateMap(mapData);
        int row = 0;
        int numTrees = 0;

        for(int col = 3; col < expandedMap[0].length; col = col + 3) {
            if(row < mapData.size() && row != 323) {
                row++;
            }

            if(expandedMap[row][col] == '#') {
                numTrees++;
            }

            System.out.println(expandedMap[row][col]);
        }

        System.out.println(numTrees);

    }
}
