package com.punch.punch.model.retrofit.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("/users/{uid}/info")
    Call<List<UserVO>> getUserInfo(@Path("uid") UserVO userVO);

    @GET("/users/{uid}/taste")
    Call<List<UserTasteVO>> getUserTasteInfo(@Path("uid") UserVO userVO);

    @PUT("/users/{uid}/taste")
    Call<List<TokenVO>> initUserTasteInfo(@Path("uid") UserVO userVO);

    @GET("/users/{uid}/groups")
    Call<List<GroupVO>> getUserGroupList(@Path("uid") UserVO userVO);

    @GET("/users/{uid}/groups/{gid}")
    Call<List<GroupVO>> getUserGroupInfo(@Path("uid") UserVO userVO , @Path("gid") GroupVO groupVO);

    @DELETE("/users/{uid}/groups/{gid}")
    Call<List<ResultVO>> exitUserGroup(@Path("uid") UserVO userVO , @Path("gid") GroupVO groupVO);
}
