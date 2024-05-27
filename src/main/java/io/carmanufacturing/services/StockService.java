package io.carmanufacturing.services;

import io.carmanufacturing.dtos.StockDto;
import org.springframework.http.ResponseEntity;

public interface StockService {


    ResponseEntity<String> addProduct(StockDto stockDto);
    ResponseEntity<String> editProduct(Long productId);
    ResponseEntity<String> deleteProduct(Long productId);
    ResponseEntity<String> getProduct(Long productId);


}
