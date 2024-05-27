package io.carmanufacturing.restImpl;

import io.carmanufacturing.constants.CarManufacturingConstants;
import io.carmanufacturing.dtos.AddressDto;
import io.carmanufacturing.rest.AddressRest;
import io.carmanufacturing.services.AddressService;
import io.carmanufacturing.utils.CarManufacturingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressRestImpl implements AddressRest {

    @Autowired
    AddressService addressService;

    @Override
    public ResponseEntity<String> getAddress(Long addressId) {
        try{
            return addressService.getAddress(addressId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @Override
    public ResponseEntity<String> addAddress(AddressDto addressDto) {
        try{
            return addressService.addAddress(addressDto);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @Override
    public ResponseEntity<String> editAddress(Long addressId) {
        try{
            return addressService.editAddress(addressId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @Override
    public ResponseEntity<String> deleteAddress(Long addressId) {
        try{
            return addressService.deleteAddress(addressId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);


    }
}
