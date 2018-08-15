package com.punch.punch.view.main;

import android.databinding.ObservableField;
import android.view.View;

import com.punch.punch.model.auth.Authentication;
import com.punch.punch.model.retrofit.service.UserService;
import com.punch.punch.model.retrofit.vo.UserTasteApi;
import com.punch.punch.util.network.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel {

    interface Navigator {

        /**
         * toast 를 통해 메시지를 알리고 싶을때 사용
         * @param message 알릴 메시지
         */
        void showToast(String message);

        void showPersonalAnalysis();

        void showGroupAnalysis();

    }

    private Navigator mNavigator;
    public final ObservableField<String> analysisResult;

    public MainViewModel(){
        analysisResult = new ObservableField<>();
    }

    public void setNavigator(Navigator navigator){
        this.mNavigator = navigator;
    }


    /**
     * MainView 가 로딩될때 호출될 start 메소드
     */
    public void onStart(){
        requestTasteFromWebApi();
    }

    /**
     * 유저의 음식 취향을 요청하는 메소드
     */
    public void onTasteLoad(){
        requestTasteFromWebApi();
    }

    public void onPersonalClick(View view){
        mNavigator.showPersonalAnalysis();
    }

    public void onGroupClick(View view){
        mNavigator.showGroupAnalysis();
    }

    private void setAnalysisResult(float salty, float sour, float sweet, float bitter, float spicy){
        analysisResult.set(String.format("%f\n%f\n%f\n%f\n%f", salty, sour, sweet, bitter, spicy));
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
                setAnalysisResult(salty, sour, sweet, bitter, spicy);
            }

            @Override
            public void onFailure(Call<UserTasteApi.GetResponseVO> call, Throwable t) {
                mNavigator.showToast(call.toString());
            }
        });
    }

}
