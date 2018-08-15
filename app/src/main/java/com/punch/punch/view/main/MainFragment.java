package com.punch.punch.view.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.punch.punch.databinding.FragmentMainBinding;


public class MainFragment extends Fragment implements MainViewModel.Navigator {

    private static final String TAG = "MainFragment";

    private Callbacks mCallbacks;
    private FragmentMainBinding mFragmentMainBinding;
    private MainViewModel mMainViewModel;

    public static MainFragment getInstance() {
        MainFragment fragment = new MainFragment();

        return fragment;
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPersonalAnalysis() {
        mCallbacks.onCallPersonalRecommend();
    }

    @Override
    public void showGroupAnalysis() {
        mCallbacks.onCallGroupRecommend();
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
        mMainViewModel.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mFragmentMainBinding = FragmentMainBinding.inflate(inflater,container,false);

        mMainViewModel = new MainViewModel();
        mMainViewModel.setNavigator(this);
        mFragmentMainBinding.setMainViewModel(mMainViewModel);

        View root = mFragmentMainBinding.getRoot();

        return root;
    }

}
