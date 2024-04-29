package io.carmanufacturing.dtos;


import lombok.Builder;

@Builder
public record TokenResponseDto(String token, String refreshToken) {
}
