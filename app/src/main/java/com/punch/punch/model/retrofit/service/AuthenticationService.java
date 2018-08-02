package com.punch.punch.model.retrofit.service;

import com.punch.punch.model.retrofit.vo.AuthenticationApi;
import com.punch.punch.model.retrofit.vo.AuthenticationsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AuthenticationService {

    @GET("/authentication/{email}")
    Call<AuthenticationApi.GetResponseVO> getUidFromEmail(@Path("email")String based64EncodedEmail);

    @POST("/authentication/")
    Call<AuthenticationsApi.PostResponseVO> signUp(@Body AuthenticationsApi.PostRequestBody emailBody);

    @DELETE("/authentication/{uid}")
    Call<Void> withDrawal(@Path("uid") int uid);

}
