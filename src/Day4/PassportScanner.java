import Util.readFile;
import java.util.ArrayList;
import java.util.HashMap;

public class PassportScanner {

    public static ArrayList<String> passportSort(ArrayList<String> batchData) {
        ArrayList<String> passportSorted = new ArrayList<>();
        String currentPassport = "";

        for (String currentLine : batchData) {
            if(currentLine.equals("")) {
                passportSorted.add(currentPassport);
                currentPassport = "";
            } else {
                if (currentPassport.equals("")) {
                    currentPassport = currentLine;
                } else {
                    currentPassport = currentPassport + " " + currentLine;
                }
            }
        }
        return passportSorted;
    }

    public static HashMap<Integer, PassportData> parsePassport(ArrayList<String> sortedData) {
        HashMap<Integer, PassportData> passportDB = new HashMap<>();
        PassportData template = new PassportData(0, 0,0,null,null,null,0,0);

        //Init Passport DB
        for(int x = 0; x < sortedData.size(); x++) {
            passportDB.put(x, template);
        }

        int passportNum = 0;

        for(String currentPassport : sortedData) {
            String[] passportSplit = currentPassport.split(" ");
            for(String cData :  passportSplit) {
                String[] temp = cData.split(":");

                switch (temp[0]) {
                    case "byr":
                        passportDB.get(passportNum).birthYear = Integer.parseInt(temp[1]);
                        break;
                    case "iyr":
                        passportDB.get(passportNum).issueYear = Integer.parseInt(temp[1]);
                        break;
                    case "eyr":
                        passportDB.get(passportNum).expYear = Integer.parseInt(temp[1]);
                        break;
                    case "hgt":
                        passportDB.get(passportNum).height = temp[1];
                        break;
                    case "hcl":
                        passportDB.get(passportNum).hairColor = temp[1];
                        break;
                    case "ecl":
                        passportDB.get(passportNum).eyeColor = temp[1];
                        break;
                    case "pid":
                        passportDB.get(passportNum).passID = Integer.parseInt(temp[1]);
                        break;
                    case "cid":
                        passportDB.get(passportNum).countryID = Integer.parseInt(temp[1]);
                        break;
                }
            }
            passportNum++;
        }
        return passportDB;
    }

    public void passportCheck() {

    }

    public static void main(String[] args) {
        readFile fileReader = new readFile();
        ArrayList<String> batchData = fileReader.readInput("src/Day4/TestInput");
        ArrayList<String> sortedData = passportSort(batchData);

        //Parsed Passport Data
        HashMap<Integer, PassportData> passportData = parsePassport(sortedData);

        System.out.println(passportData.get(0).eyeColor);
    }
}
