package com.stratosphere.productdescription.shared;

import com.stratosphere.productdescription.domain.Product;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindProductDetail {
    private final RestTemplate restTemplate;

    public FindProductDetail(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<Product> invoke(Integer productId) {
        return Optional.ofNullable(restTemplate.exchange("http://localhost:3001/product/"+productId,
                HttpMethod.GET, null, Product.class)
                .getBody());
    }

}
