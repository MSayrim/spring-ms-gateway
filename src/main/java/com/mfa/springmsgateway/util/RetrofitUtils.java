package com.mfa.springmsgateway.util;

import com.google.gson.JsonElement;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
public class RetrofitUtils {
    public static <T> T executeInBlock(Call<T> request){
        try {
            Response<T> response = request.execute();
            if(!response.isSuccessful()){
                log.error("Request completed unsuccessfully with statusCode:{} and reason:{}"
                        ,response.code()
                        ,response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
