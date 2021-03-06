package com.punch.punch.view.main;

import com.punch.punch.view.BasePresenter;
import com.punch.punch.view.BaseView;

public interface MainContract {

    interface View extends BaseView<Presenter>{

        /**
         * 유저의 음식 취향을 다섯가지 맛을 기준으로 보여주는 메소드
         */
        void displayTaste(float salty, float sour, float sweet, float bitter, float spicy);

        /**
         * toast 를 통해 메시지를 알리고 싶을때 사용
         * @param message 알릴 메시지
         */
        void showToast(String message);

    }

    interface Presenter extends BasePresenter{
        /**
         * MainView 가 로딩될때 호출될 start 메소드
         */
        void start();

        /**
         * 유저의 음식 취향을 요청하는 메소드
         */
        void requestTaste();

    }

}
