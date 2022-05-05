package de.htwberlin.webtech.finview.persistence;

import javax.persistence.*;

@Entity(name = "invests")
public class InvestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invest_id")
    private long id;

    @Column(name = "invest_name", nullable = false)
    private String investName;

    @Column(name = "invest_type", nullable = false)
    private String investType;

    @Column(name = "purchase_value")
    private int purchaseValue;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "current_value")
    private int currentValue;

    public InvestEntity(String investName, String investType, int purchaseValue, int quantity, int currentValue) {
        this.investName = investName;
        this.investType = investType;
        this.purchaseValue = purchaseValue;
        this.quantity = quantity;
        this.currentValue = currentValue;
    }

    protected InvestEntity() {}

    public long getId() {
        return id;
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
