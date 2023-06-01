package com.stratosphere.productdescription.shared;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class FindProductsSimilarList {
    private final RestTemplate restTemplate;

    public FindProductsSimilarList(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Integer> invoke(Integer productId) {
        var list = restTemplate.exchange("http://localhost:3001/product/"+productId+"/similarids",
                HttpMethod.GET, null, List.class)
                .getBody();
        return list;
    }
}
