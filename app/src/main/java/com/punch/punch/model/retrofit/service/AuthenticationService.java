package com.punch.punch.model.retrofit.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AuthenticationService {

    @GET("/authentication/{email}")
    Call<List<EmailVO>> getEmailFromUid(@Path("email")EmailVO based64EncodedEmailVO);

    @POST("/authentication/")
    Call<List<ResultVO>> signUp(@Body EmailVO emailVO);

    @DELETE("/authentication/{uid}")
    Call<List<ResultVO>> withDrawal(@Path("uid") UserVO userVO);

}
