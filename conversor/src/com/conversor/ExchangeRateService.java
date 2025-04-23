package com.conversor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class ExchangeRateService {
    private static final String API_KEY = "6bf081202cdd1531bfd29ceb";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double getExchangeRate(String from, String to) {
        try {

            String urlStr = BASE_URL + API_KEY + "/pair/" + from + "/" + to;
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner scanner = new Scanner(conn.getInputStream());
            String response = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
            scanner.close();

            JSONObject json = new JSONObject(response);


            if (json.has("conversion_rate")) {
                return json.getDouble("conversion_rate");
            } else {
                System.out.println("Respuesta inesperada de la API: " + json.toString());
                return 1.0;
            }

        } catch (IOException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 1.0;
        }
    }
}
