package com.stratosphere.productdescription.application;

import com.stratosphere.productdescription.domain.Product;
import com.stratosphere.productdescription.shared.FindProductDetail;
import com.stratosphere.productdescription.shared.FindProductsSimilarList;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class FindProductSimilar {
    private final FindProductDetail findProductDetail;
    private final FindProductsSimilarList findProductsSimilarList;

    public FindProductSimilar(RestTemplate restTemplate) {
        this.findProductDetail = new FindProductDetail(restTemplate);
        this.findProductsSimilarList = new FindProductsSimilarList(restTemplate);
    }

    public List<Product> invoke(Integer productId) {
        var productsId = findProductsSimilarList.invoke(productId);
        List<Product> products = new ArrayList<>();
        productsId.forEach(id -> {
            var product = findProductDetail.invoke(id);
            product.ifPresent(products::add);
        });
        return products;
    }

}
