public class PassportData {
    public int birthYear;
    public int issueYear;
    public int expYear;
    public String height;
    public String hairColor;
    public String eyeColor;
    public int passID;
    public int countryID;

    public PassportData(
        int birthYear,
        int issueYear,
        int expYear,
        String height,
        String hairColor,
        String eyeColor,
        int passID,
        int countryID
    ) {
        this.birthYear = birthYear;
        this.issueYear = issueYear;
        this.expYear = expYear;
        this.height = height;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.passID = passID;
        this.countryID = countryID;
    }

}
