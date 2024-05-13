package io.carmanufacturing.requests;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.dtos.UserPermissionsDto;

public class SignUpRequest {
    private UserDto userDto;
    private UserCredentialsDto userCredentialsDto;
    private UserPermissionsDto userPermissionsDto;

    // Getters and setters for all DTOs
    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public UserCredentialsDto getUserCredentialsDto() {
        return userCredentialsDto;
    }

    public void setUserCredentialsDto(UserCredentialsDto userCredentialsDto) {
        this.userCredentialsDto = userCredentialsDto;
    }

    public UserPermissionsDto getUserPermissionsDto() {
        return userPermissionsDto;
    }

    public void setUserPermissionsDto(UserPermissionsDto userPermissionsDto) {
        this.userPermissionsDto = userPermissionsDto;
    }
}