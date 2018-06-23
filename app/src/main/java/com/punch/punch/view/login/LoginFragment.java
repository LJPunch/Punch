package com.punch.punch.view.login;

import android.support.v4.app.Fragment;

import com.punch.punch.view.BasePresenter;

public class LoginFragment extends Fragment implements LoginContract.View{

    private LoginContract.Presenter mPresenter;

    public static LoginFragment getInstance(){
        LoginFragment fragment = new LoginFragment();
        
        return fragment;
    }

    @Override
    public void showSignIn() {
        
    }

    @Override
    public void showSignResult() {

    }

    @Override
    public void showMainActivity() {

    }

    @Override
    public void showAgreeActivity() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
