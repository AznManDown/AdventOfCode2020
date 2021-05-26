import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class parseFile {

    public HashMap<String,String> readInput() {
        HashMap<String,String> passInput = new HashMap<>();

        try(BufferedReader bReader = new BufferedReader(new FileReader("src/Day2/PassInput"))) {
            String currentLine;

            while((currentLine = bReader.readLine()) != null) {
                String[] currentLineSplit = currentLine.split(": ");
                passInput.put(currentLineSplit[1], currentLineSplit[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return passInput;
    }

}