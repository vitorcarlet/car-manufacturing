package io.carmanufacturing.restImpl;

import io.carmanufacturing.constants.CarManufacturingConstants;
import io.carmanufacturing.dtos.StockDto;
import io.carmanufacturing.rest.StockRest;
import io.carmanufacturing.services.StockService;
import io.carmanufacturing.utils.CarManufacturingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockRestImpl implements StockRest {

    @Autowired
    StockService stockService;

    @Override
    public ResponseEntity<String> getProduct(Long productId) {
        try{
            return stockService.getProduct(productId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> addProduct(StockDto stockDto) {
        try{
            return stockService.addProduct(stockDto);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> editProduct(Long productId) {
        try{
            return stockService.editProduct(productId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> deleteProduct(Long productId) {
        try{
            return stockService.deleteProduct(productId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
