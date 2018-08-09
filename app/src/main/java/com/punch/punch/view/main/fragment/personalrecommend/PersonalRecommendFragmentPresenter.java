package com.punch.punch.view.main.fragment.personalrecommend;

import com.punch.punch.model.retrofit.service.RecommendService;
import com.punch.punch.model.retrofit.vo.RecommendPersonalApi;
import com.punch.punch.util.network.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalRecommendFragmentPresenter implements PersonalRecommendFragmentConstract.Presenter {
    private PersonalRecommendFragmentConstract.View mView;

    public PersonalRecommendFragmentPresenter(PersonalRecommendFragmentConstract.View view) {
        mView = view;
    }

    @Override
    public void doPersonalRecommend(int uid) {
        RetrofitClient.getInstance().create(RecommendService.class).requestPersonalRecommend(uid).enqueue(new Callback<RecommendPersonalApi.GetResponseVO>() {
            @Override
            public void onResponse(Call<RecommendPersonalApi.GetResponseVO> call, Response<RecommendPersonalApi.GetResponseVO> response) {
                RecommendPersonalApi.GetResponseVO recommendedFood = response.body();
                mView.showRecommendedFood(recommendedFood);
            }
            @Override
            public void onFailure(Call<RecommendPersonalApi.GetResponseVO> call, Throwable t) {

            }
        });
    }

    @Override
    public void start() {

    }
}
