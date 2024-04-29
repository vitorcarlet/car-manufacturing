package io.carmanufacturing.rest;

import io.carmanufacturing.dtos.AuthDto;
import io.carmanufacturing.dtos.RequestRefreshDto;
import io.carmanufacturing.dtos.TokenResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/auth")
public interface AuthControllerRest {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
     TokenResponseDto auth(@RequestBody AuthDto authDto);

    @PostMapping("/refresh-token")
     TokenResponseDto authRefreshToken(@RequestBody RequestRefreshDto requestRefreshDto);

}
