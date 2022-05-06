package com.details;

public class CardDetails {
    private String cardNumbers;
    public CardDetails(String cardNumbers){
        this.cardNumbers=cardNumbers;

    }

    public String getCardNumber() {
        return cardNumbers;
    }

    public void setCardNumber(String cardNumbers) {
        this.cardNumbers = cardNumbers;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumbers='" + cardNumbers + '\'' +
                '}';
    }
}
