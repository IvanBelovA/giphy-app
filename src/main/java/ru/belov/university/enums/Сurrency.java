package ru.belov.university.enums;

public enum Сurrency {

    //Russian ruble
    RUB("RUB (Российский рубль)"),
    //Indian Rupee
    INR("INR (Индийский рупий)"),
    //Chinese Yuan
    CNY("CNY (Китайский юань)"),
    //Euro
    EUR("EUR (Евро)");

    private final String currencyRate;

    Сurrency(String currency) {
        this.currencyRate = currency;
    }

    public String getCurrency() {
        return currencyRate;
    }
}
