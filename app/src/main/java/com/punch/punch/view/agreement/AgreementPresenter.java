package com.punch.punch.view.agreement;

import com.punch.punch.model.Authentication;
import com.punch.punch.view.login.LoginContract;

public class AgreementPresenter implements AgreementContract.Presenter {

    private AgreementContract.View mView;

    public AgreementPresenter(AgreementContract.View view){
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void registAgreement(String token, String[] agreement) {
        Authentication authentication = Authentication.getInstance();
        authentication.signUp(token);

        mView.showMainActivity();
    }
}
