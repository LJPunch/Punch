package com.punch.punch.view.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.punch.punch.R;

public class MainFragment extends Fragment implements MainContract.View {

    private static final String TAG = "MainFragment";

    private Callbacks mCallbacks;
    private MainContract.Presenter mPresenter;
    private TextView mTasteView;

    public static MainFragment getInstance() {
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    @Override
    public void displayTaste(float salty, float sour, float sweet, float bitter, float spicy) {
        mTasteView.setText(String.format("%f\n%f\n%f\n%f\n%f", salty, sour, sweet, bitter, spicy));
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public interface Callbacks {
        void onCallPersonalRecommend();

        void onCallGroupRecommend();
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

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        MainContract.Presenter presenter = new MainPresenter(this);
        presenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, null);
        mTasteView = root.findViewById(R.id.text_view_taste);
        FloatingActionButton personalButton = root.findViewById(R.id.button_personal_recommend);
        personalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbacks.onCallPersonalRecommend();
            }
        });
        FloatingActionButton groupButton = root.findViewById(R.id.button_group_recommend);
        groupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbacks.onCallGroupRecommend();
            }
        });
        return root;
    }

}
