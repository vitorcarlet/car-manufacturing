package io.carmanufacturing.services;

import io.carmanufacturing.dtos.AddressDto;
import org.springframework.http.ResponseEntity;

public interface AddressService {
    ResponseEntity<String> getAddress(Long addressId);

    ResponseEntity<String> addAddress(AddressDto addressDto);

    ResponseEntity<String> editAddress(Long addressId);

    ResponseEntity<String> deleteAddress(Long addressId);
}
