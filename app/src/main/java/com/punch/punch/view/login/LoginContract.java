package com.punch.punch.view.login;

import com.punch.punch.view.BasePresenter;
import com.punch.punch.view.BaseView;

/**
 * Created by galid on 2018-06-22.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{

        /**
         * 인증을 위한 구글Oauth Api를 띄우는 메소드
         */
        void showSignIn();

        /**
         * 인증 결과를 보여주는 메소드
         */
        void showSignResult();

        /**
         * 로그인 성공시 메인화면을 띄우는 메소드
         */
        void showMainActivity();

        /**
         * 서버에 등록이 안된 회원이면 등록을 위한 약관동의
         * 액티비티를 띄우는 메소드
         * 약관 동의후 서버에 등록을 위한 토큰을 넘겨준다
         */
        void showAgreeActivity();
    }

    interface Presenter extends BasePresenter{
        /**
         * Oauth 토큰을 통해 서버에 인증 요청 메소드
         * @param token Ouath인증을 통해 받은 토큰
         */
        void requestAuthentication(String token);
    }

}
