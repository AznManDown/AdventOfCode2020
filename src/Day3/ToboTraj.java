import java.util.ArrayList;

public class ToboTraj {

    public static char[][] generateMap(ArrayList mapData, int length) {
        int mapHeight = mapData.size();
        int mapLength = length * mapHeight;
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

    public static int calculatePath(char[][]expandedMap, int x,int y) {
        int row = y - 1;
        int numTrees = 0;

            for(int col = x; col < expandedMap[0].length && row < expandedMap.length; col = col + x) {
                row = row + y;

                if(row < expandedMap.length && expandedMap[row][col] == '#') {
                    numTrees++;
                }
            }
        return numTrees;
    }

    public static void main(String[] args) {
        parseData inputData = new parseData();
        ArrayList<String> mapData = inputData.readInput();

        int[] xVal = {1,3,5,7,1};
        int[] yVal = {1,1,1,1,2};
        ArrayList<Integer> resultList = new ArrayList<>();

//        char[][] expandedMap = generateMap(mapData, 1);
//
//        System.out.println(calculatePath(expandedMap, 1, 2));

        for(int x = 0; x < xVal.length; x++) {
            char[][] expandedMap = generateMap(mapData, xVal[x]);
            int result = calculatePath(expandedMap, xVal[x], yVal[x]);

            resultList.add(result);

            System.out.println("Result for X:" + xVal[x] + " Y:" + yVal[x] + " is: " + result);
        }

        int value = resultList.get(0);
        int sum = 0;

        for(int y = 0; y < resultList.size() - 1; y++) {
            int nextVal = resultList.get(y + 1);
            value = value * nextVal;
        }
        System.out.println(value);
    }
}
