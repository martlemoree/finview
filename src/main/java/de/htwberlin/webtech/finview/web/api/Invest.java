package de.htwberlin.webtech.finview.web.api;
public class Invest {

    private long id;
    private String investName;
    private String investType;
    private int purchaseValue;
    private int quantity;
    private int currentValue;

    public Invest(long id, String investName, String investType, int purchaseValue, int quantity, int currentValue) {
        this.id = id;
        this.investName = investName;
        this.investType = investType;
        this.purchaseValue = purchaseValue;
        this.quantity = quantity;
        this.currentValue = currentValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvestName() {
        return investName;
    }

    public void setInvestName(String investName) {
        this.investName = investName;
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    public int getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(int purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
}
