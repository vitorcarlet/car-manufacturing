package io.carmanufacturing.rest;

import io.carmanufacturing.dtos.StockDto;
import io.carmanufacturing.dtos.StockPurchaseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("stock/purchases")
public interface StockPurchaseRest {
    @GetMapping("/get/{productId}")
    ResponseEntity<String> getPurchase(@PathVariable Long purchaseId);

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> addPurchase(@RequestBody StockPurchaseDto stockPurchaseDtoDto);

    @PatchMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> editPurchase(@RequestBody Long purchaseId);

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> deletePurchase(@RequestBody Long purchaseId);
}
