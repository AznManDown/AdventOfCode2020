import java.util.HashMap;

public class passwordCheck {

    public static boolean parseRules(HashMap data,String r) {
        String[] rawRule = data.get(r).toString().split(" ");
        char letter = rawRule[1].charAt(0);
        int firstVal = Integer.parseInt(rawRule[0].split("-")[0]);
        int secondVal = Integer.parseInt(rawRule[0].split("-")[1]);

        int cFirstVal = firstVal - 1;
        int cSecondVal = secondVal - 1;

        if((r.charAt(cFirstVal) == letter && r.charAt(cSecondVal) != letter) || (r.charAt(cFirstVal) != letter && r.charAt(cSecondVal) == letter)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        parseFile fileReader = new parseFile();
        HashMap<String,String> readInput = new HashMap<>(fileReader.readInput());
        String[] passVal = readInput.keySet().toArray(new String[0]);

        int validPasswords = 0;

        for (int x = 0; x < passVal.length; x++) {
            if(parseRules(readInput, passVal[x]) == true) {
                validPasswords++;
            }
        }

        System.out.println(validPasswords);
    }
}