package io.carmanufacturing.services;

import io.carmanufacturing.dtos.StockPurchaseDto;
import org.springframework.http.ResponseEntity;

public interface StockPurchaseService {
    ResponseEntity<String> getPurchase(Long purchaseId);

    ResponseEntity<String> addPurchase(StockPurchaseDto stockPurchaseDtoDto);

    ResponseEntity<String> editPurchase(Long purchaseId);

    ResponseEntity<String> deletePurchase(Long purchaseId);
}
