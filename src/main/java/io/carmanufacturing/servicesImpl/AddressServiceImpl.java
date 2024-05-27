package io.carmanufacturing.servicesImpl;

import io.carmanufacturing.dtos.AddressDto;
import io.carmanufacturing.services.AddressService;
import org.springframework.http.ResponseEntity;

public class AddressServiceImpl implements AddressService {
    @Override
    public ResponseEntity<String> getAddress(Long addressId) {
        return null;
    }

    @Override
    public ResponseEntity<String> addAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> editAddress(Long addressId) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteAddress(Long addressId) {
        return null;
    }
}
