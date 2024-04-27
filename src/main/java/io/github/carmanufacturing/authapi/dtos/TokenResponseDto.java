package io.github.carmanufacturing.authapi.dtos;


import lombok.Builder;

@Builder
public record TokenResponseDto(String token, String refreshToken) {
}
