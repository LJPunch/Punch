package com.punch.punch.view.main.fragment.personalrecommend;

import com.punch.punch.model.retrofit.vo.RecommendPersonalApi;
import com.punch.punch.view.BasePresenter;
import com.punch.punch.view.BaseView;

public interface PersonalRecommendFragmentConstract {
    interface View extends BaseView<Presenter>{
        void showRecommendedFood(RecommendPersonalApi.GetResponseVO food);
    }
    interface Presenter extends BasePresenter{
        void doPersonalRecommend(int uid);
    }
}
