package com.punch.punch.view.agreement;

import com.punch.punch.view.BasePresenter;
import com.punch.punch.view.BaseView;

/**
 * Created by galid on 2018-06-22.
 */

public interface AgreementContract {
    String POLICY_USE = "POLICY_USE"; // 이용 동의 약관
    String POLICY_USE_PRIVACY = "POLICY_USE_PRIVACY"; // 개인정보 사용 동의 약관
    String POLICY_ADVERTISEMENT_RECEIVE = "POLICY_ADVERTISEMENT_RECEIVE"; // 광고 수신 동의 약관

    interface View extends BaseView<Presenter>{
        /**
         * 약관동의 후에 메인화면을 띄우는 메소드
         */
        void showMainActivity();
    }

    interface Presenter extends BasePresenter{
        /**
         * 약관동의 후에 서버에 등록을 위한 메소드
         * @param token Oauth 인증을 통해 얻어온 토큰
         * @param agreement 사용자가 동의한 배열
         */
        void registAgreement(String token , String[] agreement);
    }

}
