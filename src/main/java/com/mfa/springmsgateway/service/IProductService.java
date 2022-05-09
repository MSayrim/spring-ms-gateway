package com.mfa.springmsgateway.service;

import com.google.gson.JsonElement;

import java.util.List;

public interface IProductService {
    JsonElement saveProduct(JsonElement requestBody);

    void deleteProduct(Long productId);

    List<JsonElement> getAllProduct();
}
