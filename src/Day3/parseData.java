import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class parseData {

    public ArrayList<String> readInput() {
        ArrayList<String> mapInput = new ArrayList();

        try(BufferedReader bReader = new BufferedReader(new FileReader("src/Day3/DayInput"))) {
            String currentLine;

            while((currentLine = bReader.readLine()) != null) {
                mapInput.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapInput;
    }

}