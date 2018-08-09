package com.punch.punch.view.main.fragment.main;

import com.punch.punch.model.retrofit.service.UserService;
import com.punch.punch.model.retrofit.vo.UserTasteApi;
import com.punch.punch.util.network.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragmentPresenter implements MainFragmentContract.Presenter {

    private MainFragmentContract.View mView;

    public MainFragmentPresenter(MainFragmentContract.View view){
        mView = view;
    }

    @Override
    public void getUserTaste(int uid) {
        //TODO get User Taste Info
        RetrofitClient.getInstance().create(UserService.class).getUserTasteInfo(uid).enqueue(new Callback<UserTasteApi.GetResponseVO>() {
            @Override
            public void onResponse(Call<UserTasteApi.GetResponseVO> call, Response<UserTasteApi.GetResponseVO> response) {
                if(response.isSuccessful()){
                    //TODO success
                    UserTasteApi.GetResponseVO userTaste = response.body();
                    mView.showUserTaste(userTaste);
                }
                //TODO error code
            }
            @Override
            public void onFailure(Call<UserTasteApi.GetResponseVO> call, Throwable t) {
            }
        });
    }

    @Override
    public void start() {
        //TODO uid 받아올 방법 마련
        //getUserTaste();
    }

}
