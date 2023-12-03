package com.example.fpfrontend.handler;

import com.example.fpfrontend.dto.OperatorAuthenticationResultDto;

@FunctionalInterface
public interface AuthenticationResultHandler {
    void handle(OperatorAuthenticationResultDto operatorAuthenticationResultDto);

}
