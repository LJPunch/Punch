package com.punch.punch.view.login;

import com.punch.punch.model.auth.Authentication;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private Authentication mAuthentication;

    public LoginPresenter(LoginContract.View view, Authentication authentication){
        mView = view;
        mView.setPresenter(this);
        mAuthentication = authentication;
    }

    @Override
    public void requestAuthentication(String token) {
        Authentication authentication = mAuthentication;
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

    @Override
    public void start() {

    }
}
