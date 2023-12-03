package com.example.fpfrontend.rest;

import com.example.fpfrontend.dto.OperatorCredentialsDto;
import com.example.fpfrontend.handler.AuthenticationResultHandler;

public interface Authenticator {

    void authenticate(OperatorCredentialsDto operatorCredentialsDto, AuthenticationResultHandler resultHandler );


}
