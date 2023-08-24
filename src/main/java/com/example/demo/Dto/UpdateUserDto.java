package com.example.demo.Dto;

public record UpdateUserDto(
        String username,
        String old_password,
        String new_password
) {
}
