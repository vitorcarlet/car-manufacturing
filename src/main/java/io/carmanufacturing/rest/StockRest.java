package io.carmanufacturing.rest;

import io.carmanufacturing.dtos.StockDto;
import io.carmanufacturing.entities.Stock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/stock")
public interface StockRest {

    @GetMapping("/get/{productId}")
    ResponseEntity<String> getProduct(@PathVariable Long productId);

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> addProduct(@RequestBody StockDto stockDto);

    @PatchMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> editProduct(@RequestBody Long productId);

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> deleteProduct(@RequestBody Long productId);

}
