package com.punch.punch.view.agreement;

import android.view.View;

import com.punch.punch.model.auth.Authentication;

public class AgreementViewModel {

    private static final String POLICY_USE = "POLICY_USE"; // 이용 동의 약관
    private static final String POLICY_USE_PRIVACY = "POLICY_USE_PRIVACY"; // 개인정보 사용 동의 약관
    private static final String POLICY_ADVERTISEMENT_RECEIVE = "POLICY_ADVERTISEMENT_RECEIVE"; // 광고 수신 동의 약관

    interface Navigator {
        /**
         * 약관동의 후에 메인화면을 띄우는 메소드
         */
        void showMainActivity();
    }

    private Navigator mNavigator;
    private String mToken;

    public AgreementViewModel(String token){
        this.mToken = token;
    }

    public void setNavigator(Navigator navigator){
        this.mNavigator = navigator;
    }

    public void onSignUpClick(View view) {
        Authentication authentication = Authentication.getInstance();
        authentication.signUp(mToken);

        mNavigator.showMainActivity();
    }

}
