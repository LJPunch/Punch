package com.punch.punch.model.retrofit.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GroupService {

    @POST("/groups/")
    Call<List<ResultVO>> makeGroup(@Body GroupVO groupMakeVO);

}
