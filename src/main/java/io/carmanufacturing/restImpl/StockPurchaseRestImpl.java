package io.carmanufacturing.restImpl;

import io.carmanufacturing.constants.CarManufacturingConstants;
import io.carmanufacturing.dtos.StockPurchaseDto;
import io.carmanufacturing.rest.StockPurchaseRest;
import io.carmanufacturing.services.StockPurchaseService;
import io.carmanufacturing.utils.CarManufacturingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StockPurchaseRestImpl implements StockPurchaseRest {

    @Autowired
    StockPurchaseService stockPurchaseService;

    @Override
    public ResponseEntity<String> getPurchase(Long purchaseId) {
        try{
            return stockPurchaseService.getPurchase(purchaseId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> addPurchase(StockPurchaseDto stockPurchaseDtoDto) {
        try{
            return stockPurchaseService.addPurchase(stockPurchaseDtoDto);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> editPurchase(Long purchaseId) {
        try{
            return stockPurchaseService.editPurchase(purchaseId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> deletePurchase(Long purchaseId) {
        try{
            return stockPurchaseService.deletePurchase(purchaseId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
