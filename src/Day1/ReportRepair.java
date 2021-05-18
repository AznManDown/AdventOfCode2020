import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReportRepair {

    public static void main(String[] args) {

        ArrayList<Integer> inputList = new ArrayList<>();

        try (BufferedReader bReader = new BufferedReader(new FileReader("src/Day1/input"))) {
            String currentLine;

            while((currentLine = bReader.readLine()) != null) {
                inputList.add(Integer.parseInt(currentLine));
            }

            System.out.println(inputList);
        } catch (IOException error) {
            error.printStackTrace();
        }

        int numA = 0;
        int numB = 0;
        int numC = 0;
        int addedValue = 0;
        int arraySize = inputList.size();

        for(int i = 0; i < arraySize; i++) {
            numA = inputList.get(i);

            for(int y = 0; y < arraySize; y++) {
                numB = inputList.get(y);

                for(int z = 0; z < arraySize; z++)  {
                    numC = inputList.get(z);
                    addedValue = numA + numB + numC;

                    if(addedValue == 2020) {
                        System.out.println("Target Reached");
                        break;
                    }
                }
                if(addedValue == 2020) {
                    break;
                }
            }
            if(addedValue == 2020) {
                System.out.println("Quit now");
                break;
            }
        }
        System.out.println(numA);
        System.out.println(numB);
        System.out.println(numC);
        System.out.println(numA * numB * numC);
    }
}
