package com.github.durakin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

public class App {
    private static final String url = "http://localhost:8080/Lab7_war/apparels";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println(retrieveApparel(13));
        var apparels = retrieveAll();
        for (var i : apparels) { System.out.println(i); }
        var apparel = new Apparel();
        apparel.setPrice(BigDecimal.valueOf(120.91));
        apparel.setInStock(120);
        apparel.setApparelType("Added via REST API during lab7 tests");

        System.out.println(create(apparel));

        deleteApparel(38);

        updateApparel(39, 60, BigDecimal.valueOf(50));
    }

    public static Apparel retrieveApparel(int id) {
        return new RestTemplate().getForObject(
                url + "/{id}",
                Apparel.class, id);
    }

    public static Apparel[] retrieveAll() {
        return new RestTemplate().getForObject(url + '/', Apparel[].class);
    }

    public static void deleteApparel(int id) {
        new RestTemplate().delete(url + "/{id}", id);
    }

    public static void updateApparel(Integer id, int newInStock, BigDecimal newPrice) {

        var restTemplate = new RestTemplate();
        var apparelJsonObject = new JSONObject();

        apparelJsonObject.put("newInStock", newInStock);
        apparelJsonObject.put("newPrice", newPrice);

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request =
                new HttpEntity<String>(apparelJsonObject.toString(), headers);

        restTemplate.put(url+'/'+id.toString(), request);
    }

    public static URI create(Apparel apparel) throws JsonProcessingException {
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var apparelJsonObject = new JSONObject();

        apparelJsonObject.put("price", apparel.getPrice());
        apparelJsonObject.put("inStock", apparel.getInStock());
        apparelJsonObject.put("apparelType", apparel.getApparelType());

        if (apparel.getSize() != null) {
            apparelJsonObject.put("size", apparel.getSize());
        }
        if (apparel.getSex() != null) {
            apparelJsonObject.put("sex", apparel.getApparelType());
        }

        HttpEntity<String> request =
                new HttpEntity<String>(apparelJsonObject.toString(), headers);

        return restTemplate.postForLocation(url, request);
    }
}
