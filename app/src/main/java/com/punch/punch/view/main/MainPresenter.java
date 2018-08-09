package com.punch.punch.view.main;

import com.punch.punch.model.auth.Authentication;
import com.punch.punch.model.retrofit.service.UserService;
import com.punch.punch.model.retrofit.vo.UserTasteApi;
import com.punch.punch.util.network.retrofit.RetrofitClient;
import com.punch.punch.view.login.LoginContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private Authentication mAuthentication;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        requestTasteFromWebApi();
    }

    @Override
    public void requestTaste() {
        requestTasteFromWebApi();
    }

    private void requestTasteFromWebApi() {
        RetrofitClient client = RetrofitClient.getInstance();
        UserService service = client.create(UserService.class);
        int uid = Authentication.getInstance().getUid();
        Call<UserTasteApi.GetResponseVO> call = service.getUserTasteInfo(uid);
        call.enqueue(new Callback<UserTasteApi.GetResponseVO>() {
            @Override
            public void onResponse(Call<UserTasteApi.GetResponseVO> call, Response<UserTasteApi.GetResponseVO> response) {
                UserTasteApi.GetResponseVO vo = response.body();
                float bitter = vo.bitter / 10000.0f;
                float salty = vo.salty / 10000.0f;
                float sour = vo.sour / 10000.0f;
                float spicy = vo.spicy / 10000.0f;
                float sweet = vo.sweet / 10000.0f;
                mView.displayTaste(salty, sour, sweet, bitter, spicy);
            }

            @Override
            public void onFailure(Call<UserTasteApi.GetResponseVO> call, Throwable t) {

            }
        });
    }
}
