package com.stratosphere.productdescription.infrastructure;

import com.stratosphere.productdescription.application.FindProductSimilar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class GetProductSimilarController {
    private final FindProductSimilar findProductSimilar;

    public GetProductSimilarController (RestTemplate restTemplate) {
        this.findProductSimilar = new FindProductSimilar(restTemplate);
    }

    @GetMapping("/{productId}/similar")
    public ResponseEntity<?> invoke(@PathVariable("productId") Integer productId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findProductSimilar.invoke(productId));
    }
}
