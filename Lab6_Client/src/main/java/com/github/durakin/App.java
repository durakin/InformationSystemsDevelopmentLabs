package com.github.durakin;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class App {
    private static final String url = "http://localhost:8080/Lab6_war/apparels";

    public static void main(String[] args) {
        System.out.println(retrieveApparel(13));

        var apparel = new Apparel();
        apparel.setPrice(120.91);
        apparel.setInStock(120);
        apparel.setApparelType("Apparel added via REST API");

        var apparelJson = new JSONObject();
        apparelJson.put("price", 120.99);
        apparelJson.put("inStock", 120);
        apparelJson.put("apparelType", "Apparel added via REST API");

        // System.out.println(create(apparel));

        deleteApparel(20);
    }

    public static String retrieveApparel(int id) {
        return new RestTemplate().getForObject(
                url + "/{id}",
                String.class, id);
    }

    public static void deleteApparel(int id) {
        new RestTemplate().delete(url + "/{id}", id);
    }

    public static Apparel create(Apparel apparel) {
        var restTemplate = new RestTemplate();
        var newApparel = restTemplate.postForObject(url, apparel, Apparel.class);
        return newApparel;
    }
}
