package com.punch.punch.view;

/**
 * Created by galid on 2018-06-22.
 */

public interface BaseView <T extends BasePresenter>{

    void setPresenter(T presenter);

}
