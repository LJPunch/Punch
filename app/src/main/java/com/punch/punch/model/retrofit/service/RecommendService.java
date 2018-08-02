package com.punch.punch.model.retrofit.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RecommendService {

    @GET("/recommend/personal/{uid}")
    Call<List<FoodVO>> requestPersonalRecommend(@Path("uid") UserVO userVO);

    @GET("/recommend/group/{gid}")
    Call<List<FoodVO>> requestGroupRecommend(@Path("gid") GroupVO groupVO);

}
