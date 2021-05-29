package Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readFile {

    public ArrayList<String> readInput(String filePath) {
        ArrayList<String> fileData = new ArrayList();

        try(BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;

            while((currentLine = bReader.readLine()) != null) {
                fileData.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData;
    }
}
