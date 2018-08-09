package com.punch.punch.view.main.fragment.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.punch.punch.R;
import com.punch.punch.model.retrofit.vo.UserTasteApi;

public class MainFragment extends Fragment implements MainFragmentContract.View{

    private static final String TAG = "MainFragment";
    private TextView textViewUserSpicyTaste;
    private Button buttonPersonalRecommend;
    private Button buttonGroupReccomend;

    private MainFragmentContract.Presenter mPresenter;
    private Callbacks mCallbacks;

    public interface Callbacks{
        void attachPersonalRecommendFragment();
        void attachGroupRecommendFragment();
    }

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a;

        if (context instanceof Activity) {
            a = (Activity) context;
            if (a instanceof Callbacks) {
                mCallbacks = (Callbacks) a;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main,container , false);
        mPresenter = new MainFragmentPresenter(this);
        setPresenter(mPresenter);

        textViewUserSpicyTaste = root.findViewById(R.id.textview_mainfragment_spicytaste);
        buttonPersonalRecommend = root.findViewById(R.id.button_mainfragment_grouprecommend);
        buttonPersonalRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbacks.attachPersonalRecommendFragment();
            }
        });

        buttonGroupReccomend = root.findViewById(R.id.button_mainfragment_grouprecommend);
        buttonGroupReccomend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbacks.attachGroupRecommendFragment();
            }
        });

        return root;
    }

    // 유저의 성향을 띄워주는 메소드
    @Override
    public void showUserTaste(UserTasteApi.GetResponseVO userTaste) {
        textViewUserSpicyTaste.setText(userTaste.spicy);
    }

    @Override
    public void setPresenter(MainFragmentContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mCallbacks != null)
         mCallbacks = null;
    }

}
