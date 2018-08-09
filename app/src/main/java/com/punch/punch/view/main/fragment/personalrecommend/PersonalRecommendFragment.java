package com.punch.punch.view.main.fragment.personalrecommend;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.punch.punch.R;
import com.punch.punch.model.retrofit.vo.RecommendPersonalApi;

public class PersonalRecommendFragment extends Fragment implements PersonalRecommendFragmentConstract.View{
    private Callbacks mCallbacks;

    private PersonalRecommendFragmentConstract.Presenter mPresenter;

    private ImageView imageViewRecommendedFood;
    private Button buttonOk;

    public interface Callbacks{
        void attachMainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a;

        if(context instanceof Activity){
            a = (Activity)context;
            if(a instanceof Callbacks)
                mCallbacks = (Callbacks) a;
        }
    }

    public static PersonalRecommendFragment newInstance(){
        PersonalRecommendFragment personalRecommendFragment = new PersonalRecommendFragment();
        return personalRecommendFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_personalrecommend, container, false);
        PersonalRecommendFragmentConstract.Presenter presenter = new PersonalRecommendFragmentPresenter(this);
        setPresenter(presenter);

        imageViewRecommendedFood = view.findViewById(R.id.imageview_personalrecommendfragment_recommendedfood);

        buttonOk = view.findViewById(R.id.button_mainfragment_personalrecommend_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbacks.attachMainFragment();
            }
        });

        return view;
    }

    @Override
    public void showRecommendedFood(RecommendPersonalApi.GetResponseVO food) {
        Glide.with(imageViewRecommendedFood)
                .load(food.foodpicture)
                .into(imageViewRecommendedFood);
    }

    @Override
    public void setPresenter(PersonalRecommendFragmentConstract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mCallbacks != null)
            mCallbacks = null;
    }
}
