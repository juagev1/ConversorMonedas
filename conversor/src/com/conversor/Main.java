package com.conversor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        Menu menu = new Menu(scanner, converter);

        menu.start();
    }
}
