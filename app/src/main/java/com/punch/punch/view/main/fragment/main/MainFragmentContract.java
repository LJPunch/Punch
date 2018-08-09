package com.punch.punch.view.main.fragment.main;

import com.punch.punch.model.retrofit.vo.UserTasteApi;
import com.punch.punch.view.BasePresenter;
import com.punch.punch.view.BaseView;

public interface MainFragmentContract {
    interface View extends BaseView<Presenter>{
        void showUserTaste(UserTasteApi.GetResponseVO userTaste);
    }
    interface Presenter extends BasePresenter {
        void getUserTaste(int uid);
    }
}
