import java.util.HashMap;

public class passwordCheck {

    public static boolean parseRules(HashMap data,String r) {
        String[] rawRule = data.get(r).toString().split(" ");
        char letter = rawRule[1].charAt(0);
        int minCount = Integer.parseInt(rawRule[0].split("-")[0]);
        int maxCount = Integer.parseInt(rawRule[0].split("-")[1]);
        int charCount = 0;

        for (int x = 0; x < r.length(); x++) {
            if(r.charAt(x) == letter) {
                charCount++;
            }
        }

        if((charCount >= minCount) && (charCount <= maxCount)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        parseFile fileReader = new parseFile();
        HashMap<String,String> readInput = new HashMap<>(fileReader.readInput());
        String[] passVal = readInput.keySet().toArray(new String[0]);

        boolean test = parseRules(readInput, passVal[0]);
    }
}