package com.punch.punch;

import com.punch.punch.model.Authentication;
import com.punch.punch.view.login.LoginContract;
import com.punch.punch.view.login.LoginFragment;
import com.punch.punch.view.login.LoginPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class LoginContractTest {

    LoginContract.View view;
    LoginPresenter presenter;
    Authentication authentication;

    @Before
    public void beforTest() {
        view = Mockito.mock(LoginFragment.class);
        authentication = Mockito.spy(Authentication.getInstance());
        presenter =  new LoginPresenter(view, authentication);

    }

    @Test
    public void loginSuccess_when_sign_in_true() {

        Mockito.when(authentication.signIn(Mockito.anyString())).thenReturn(true);

        presenter.requestAuthentication(Mockito.anyString());

        Mockito.verify(authentication).getUid();
        Mockito.verify(view).showSignResult(true);
    }

    @Test
    public void loginFail_when_sign_in_false() {

        Mockito.when(authentication.signIn(Mockito.anyString())).thenReturn(false);

        presenter.requestAuthentication(Mockito.anyString());

        Mockito.verify(authentication).getUid();
        Mockito.verify(view).showSignResult(false);
    }
}
