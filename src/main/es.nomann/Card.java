package es.nomann;

public class Card {

    private int id;
    private int clientId;
    private String cardBrand;
    private String cardType;
    private long cardNumber;
    private String expires;
    private int cvv;
    private boolean hasChip;
    private int numCardsIssued;
    private int creditLimit;
    private String acctOpenDate;
    private int yearPinLastChanged;
    private boolean CardonDarkWeb;

    public Card(){}

    public int  getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public String getCardBrand() {
        return cardBrand;
    }
    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }
    public String getCardType() {
        return cardType;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public long getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getExpires() {
        return expires;
    }
    public void setExpires(String expires) {
        this.expires = expires;
    }
    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public boolean isHasChip() {
        return hasChip;
    }
    public void setHasChip(boolean hasChip) {
        this.hasChip = hasChip;
    }
    public int getNumCardsIssued() {
        return numCardsIssued;
    }
    public void setNumCardsIssued(int numCardsIssued) {
        this.numCardsIssued = numCardsIssued;
    }
    public int getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }
    public String getAcctOpenDate() {
        return acctOpenDate;
    }
    public void setAcctOpenDate(String acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public int getYearPinLastChanged() {
        return yearPinLastChanged;
    }
    public void setYearPinLastChanged(int yearPinLastChanged) {
        this.yearPinLastChanged = yearPinLastChanged;
    }
    public boolean isCardonDarkWeb() {
        return CardonDarkWeb;
    }
    public void setCardonDarkWeb(boolean cardonDarkWeb) {
        CardonDarkWeb = cardonDarkWeb;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", cardBrand='" + cardBrand + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNumber=" + cardNumber +
                ", expires='" + expires + '\'' +
                ", cvv=" + cvv +
                ", hasChip=" + hasChip +
                ", numCardsIssued=" + numCardsIssued +
                ", creditLimit=" + creditLimit +
                ", acctOpenDate='" + acctOpenDate + '\'' +
                ", yearPinLastChanged=" + yearPinLastChanged +
                ", CardonDarkWeb=" + CardonDarkWeb +
                '}';
    }

}
