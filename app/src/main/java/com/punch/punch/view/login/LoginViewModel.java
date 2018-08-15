package com.punch.punch.view.login;

import android.view.View;

import com.punch.punch.model.auth.Authentication;

public class LoginViewModel {

    interface Navigator {
        void googleSignIn();

        void showMainActivity();

        void showAgreeActivity(String token);

        void showSignResult(boolean isSuccess);
    }

    private Navigator mNavigator;

    public void setNavigator(Navigator navigator){
        this.mNavigator = navigator;
    }

    public void onSignInClick(View view) {
        mNavigator.googleSignIn();
    }

    public void onSuccessGoogleSignIn(String token){
        Authentication authentication = Authentication.getInstance();
        boolean isSuccess = authentication.signIn(token);
        int uid = authentication.getUid();
        if(isSuccess){
            mNavigator.showSignResult(true);
            mNavigator.showMainActivity();
        }else{
            mNavigator.showSignResult(false);
            mNavigator.showAgreeActivity(token);
        }
    }

    public void onFailGoogleSignIn(){

    }
}
