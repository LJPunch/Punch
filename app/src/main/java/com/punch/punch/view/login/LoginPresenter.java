package com.punch.punch.view.login;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view){
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void requestAuthentication(String token) {

    }
}
