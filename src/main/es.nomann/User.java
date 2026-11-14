package es.nomann;

public class User {

    private int id;
    private int currentAge;
    private int retirementAge;
    private int birthYear;
    private int birthMonth;
    private String gender;
    private String address;
    private double latitude;
    private double longitude;
    private int perCapitaIncome;
    private int yearlyIncome;
    private int totalDebt;
    private int creditScore;
    private int numCreditCards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    public int getRetirementAge() {
        return retirementAge;
    }

    public void setRetirementAge(int retirementAge) {
        this.retirementAge = retirementAge;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPerCapitaIncome() {
        return perCapitaIncome;
    }

    public void setPerCapitaIncome(int perCapitaIncome) {
        this.perCapitaIncome = perCapitaIncome;
    }

    public int getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(int yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public int getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(int totalDebt) {
        this.totalDebt = totalDebt;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getNumCreditCards() {
        return numCreditCards;
    }

    public void setNumCreditCards(int numCreditCards) {
        this.numCreditCards = numCreditCards;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", currentAge=" + currentAge +
                ", retirementAge=" + retirementAge +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", perCapitaIncome=" + perCapitaIncome +
                ", yearlyIncome=" + yearlyIncome +
                ", totalDebt=" + totalDebt +
                ", creditScore=" + creditScore +
                ", numCreditCards=" + numCreditCards +
                '}';
    }
}