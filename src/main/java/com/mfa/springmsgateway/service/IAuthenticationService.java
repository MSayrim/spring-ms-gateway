package com.mfa.springmsgateway.service;

import com.mfa.springmsgateway.model.User;

public interface IAuthenticationService {
    String signInAndReturnJWT(User singInRequest);
}
