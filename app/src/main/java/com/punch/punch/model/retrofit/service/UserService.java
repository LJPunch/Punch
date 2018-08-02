package com.punch.punch.model.retrofit.service;

import com.punch.punch.model.retrofit.vo.UserGroupApi;
import com.punch.punch.model.retrofit.vo.UserGroupsApi;
import com.punch.punch.model.retrofit.vo.UserInfoApi;
import com.punch.punch.model.retrofit.vo.UserTasteApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("/users/{uid}/info")
    Call<UserInfoApi.GetResponseVO> getUserInfo(@Path("uid") int uid);

    @GET("/users/{uid}/taste")
    Call<UserTasteApi.GetResponseVO> getUserTasteInfo(@Path("uid") int uid);

    @PUT("/users/{uid}/taste")
    Call<Void> initUserTasteInfo(@Path("uid") int uid);

    @GET("/users/{uid}/groups")
    Call<UserGroupsApi.GetResponseVO> getUserGroupList(@Path("uid") int uid);

    @GET("/users/{uid}/groups/{gid}")
    Call<UserGroupApi.GetResponseVO> getUserGroupInfo(@Path("uid") int uid , @Path("gid") int gid);

    @DELETE("/users/{uid}/groups/{gid}")
    Call<Void> exitUserGroup(@Path("uid") int uid , @Path("gid") int gid);
}
