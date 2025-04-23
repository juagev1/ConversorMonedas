package com.conversor;

public class CurrencyConverter {
    private final ExchangeRateService service = new ExchangeRateService();

    public void convert(int option, double amount) {
        String from = "";
        String to = "";

        switch (option) {
            case 1 -> { from = "USD"; to = "ARS"; }
            case 2 -> { from = "ARS"; to = "USD"; }
            case 3 -> { from = "USD"; to = "BRL"; }
            case 4 -> { from = "BRL"; to = "USD"; }
            case 5 -> { from = "EUR"; to = "USD"; }
            case 6 -> { from = "USD"; to = "EUR"; }
            case 7 -> { from = "USD"; to = "COP"; }
            case 8 -> { from = "COP"; to = "USD"; }
        }

        double rate = service.getExchangeRate(from, to);
        double result = amount * rate;

        System.out.printf("El valor de %.2f %s corresponde a %.2f %s\n",
                amount, from, result, to);
    }
}
