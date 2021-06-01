public class PassportData {
    public long birthYear;
    public long issueYear;
    public long expYear;
    public String height;
    public String hairColor;
    public String eyeColor;
    public long passID;
    public long countryID;

    public PassportData(
        long birthYear,
        long issueYear,
        long expYear,
        String height,
        String hairColor,
        String eyeColor,
        long passID,
        long countryID
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
