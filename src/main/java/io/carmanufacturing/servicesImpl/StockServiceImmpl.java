package io.carmanufacturing.servicesImpl;

import io.carmanufacturing.dtos.StockDto;
import io.carmanufacturing.services.StockService;
import org.springframework.http.ResponseEntity;

public class StockServiceImmpl implements StockService {
    @Override
    public ResponseEntity<String> addProduct(StockDto stockDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> editProduct(Long productId) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long productId) {
        return null;
    }

    @Override
    public ResponseEntity<String> getProduct(Long productId) {
        return null;
    }
}
