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
        //Loop Iteration missing last passport. Adding manually outside of loop.
        passportSorted.add(currentPassport);
        return passportSorted;
    }

    public static HashMap<Integer, PassportData> parsePassport(ArrayList<String> sortedData) {
        HashMap<Integer, PassportData> passportDB = new HashMap<>();

        //Init Passport DB
        for(int x = 0; x < sortedData.size(); x++) {
            passportDB.put(x, new PassportData(0,0,0,null,null,null,0,0));
        }

        int passportNum = 0;

        for(String currentPassport : sortedData) {
            String[] passportSplit = currentPassport.split(" ");
            for(String cData :  passportSplit) {
                String[] temp = cData.split(":");

                switch (temp[0]) {
                    case "byr":
                        try {
                            passportDB.get(passportNum).birthYear = Long.parseLong(temp[1]);
                        } catch (Exception error) {
                            System.out.println("Invalid Data in Birth Year: " + temp[1]);
                        }
                        break;
                    case "iyr":
                        try {
                            passportDB.get(passportNum).issueYear = Long.parseLong(temp[1]);
                        } catch (Exception error) {
                            System.out.println("Invalid Data in Issue Year: " + temp[1]);
                        }
                        break;
                    case "eyr":
                        try {
                            passportDB.get(passportNum).expYear = Long.parseLong(temp[1]);
                        } catch (Exception error) {
                            System.out.println("Invalid Data in eye color: " + temp[1]);
                        }
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
                        try {
                            passportDB.get(passportNum).passID = Long.parseLong(temp[1]);
                        } catch (Exception error) {
                            passportDB.get(passportNum).passID = 1;
                            System.out.println("Invalid Data in PassID:" + temp[1]);
                        }
                        break;
                    case "cid":
                        try {
                            passportDB.get(passportNum).countryID = Long.parseLong(temp[1]);
                        } catch (Exception error) {
                            System.out.println("Invalid Data in Country ID: " + temp[1]);
                        }
                        break;
                }
            }
            passportNum++;
        }
        return passportDB;
    }

    public static void passportCheck(HashMap<Integer, PassportData> passportData) {
        int validPassports = 0;
        for(int x = 0; x < passportData.size(); x++) {
            PassportData currentPassport = passportData.get(x);

            if(
                    currentPassport.birthYear != 0 &&
                    currentPassport.issueYear != 0 &&
                    currentPassport.expYear != 0 &&
                    currentPassport.height != null &&
                    currentPassport.hairColor != null &&
                    currentPassport.eyeColor != null &&
                    currentPassport.passID != 0
            ) {
                validPassports++;
            }
        }
        System.out.println(validPassports);
    }

    public static void main(String[] args) {
        readFile fileReader = new readFile();
        ArrayList<String> batchData = fileReader.readInput("src/Day4/TestInput");
        ArrayList<String> sortedData = passportSort(batchData);

        //Parsed Passport Data
        HashMap<Integer, PassportData> passportData = parsePassport(sortedData);

        passportCheck(passportData);
    }
}
