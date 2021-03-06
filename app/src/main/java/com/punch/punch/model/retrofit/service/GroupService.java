package com.punch.punch.model.retrofit.service;

import com.punch.punch.model.retrofit.vo.GroupsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GroupService {

    @POST("/groups/")
    Call<GroupsApi.PostResponseVO> makeGroup(@Body GroupsApi.PostRequestBody groupMakeBody);

}
