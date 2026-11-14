package es.nomann;

public class Transaction {

    private int id;
    private String cliendId;
    private int cardId;
    private int amount;
    private String use_chip;
    private int merchantId;
    private String merchantCity;
    private String merchantState;
    private int zip;
    private int mcc;
    private String errors;

    public Transaction() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliendId() {
        return cliendId;
    }

    public void setCliendId(String cliendId) {
        this.cliendId = cliendId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUse_chip() {
        return use_chip;
    }

    public void setUse_chip(String use_chip) {
        this.use_chip = use_chip;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantCity() {
        return merchantCity;
    }

    public void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }

    public String getMerchantState() {
        return merchantState;
    }

    public void setMerchantState(String merchantState) {
        this.merchantState = merchantState;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", cliendId='" + cliendId + '\'' +
                ", cardId=" + cardId +
                ", amount=" + amount +
                ", use_chip='" + use_chip + '\'' +
                ", merchantId=" + merchantId +
                ", merchantCity='" + merchantCity + '\'' +
                ", merchantState='" + merchantState + '\'' +
                ", zip=" + zip +
                ", mcc=" + mcc +
                ", errors='" + errors + '\'' +
                '}';
    }

}
