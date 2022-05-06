package de.htwberlin.webtech.finview.web.api;

public class InvestManipulationRequest {

    private String investName;
    private String investType;
    private int purchaseValue;
    private int quantity;
    private int currentValue;

    public InvestManipulationRequest(String investName, String investType, int purchaseValue, int quantity, int currentValue) {
        this.investName = investName;
        this.investType = investType;
        this.purchaseValue = purchaseValue;
        this.quantity = quantity;
        this.currentValue = currentValue;
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
