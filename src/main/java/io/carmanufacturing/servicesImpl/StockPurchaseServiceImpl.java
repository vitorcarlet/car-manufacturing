package io.carmanufacturing.servicesImpl;

import io.carmanufacturing.dtos.StockPurchaseDto;
import io.carmanufacturing.services.StockPurchaseService;
import org.springframework.http.ResponseEntity;

public class StockPurchaseServiceImpl implements StockPurchaseService {
    @Override
    public ResponseEntity<String> getPurchase(Long purchaseId) {
        return null;
    }

    @Override
    public ResponseEntity<String> addPurchase(StockPurchaseDto stockPurchaseDtoDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> editPurchase(Long purchaseId) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletePurchase(Long purchaseId) {
        return null;
    }
}
