package com.punch.punch.model.retrofit.service;

import com.punch.punch.model.retrofit.vo.RecommendPersonalApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RecommendService {

    @GET("/recommend/personal/{uid}")
    Call<RecommendPersonalApi.GetResponseVO> requestPersonalRecommend(@Path("uid") int uid);

}
