package com.punch.punch.view.login;

import com.punch.punch.model.Authentication;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view){
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void requestAuthentication(String token) {
        Authentication authentication = Authentication.getInstance();
        boolean isSuccess = authentication.signIn(token);
        String uid = authentication.getUid();
        if(isSuccess){
            mView.showSignResult(true);
            mView.showMainActivity();
        }else{
            mView.showSignResult(false);
            mView.showAgreeActivity(token);
        }
    }
}
