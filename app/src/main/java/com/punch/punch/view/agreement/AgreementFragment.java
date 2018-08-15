package com.punch.punch.view.agreement;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punch.punch.databinding.FragmentAgreementBinding;

public class AgreementFragment extends Fragment implements AgreementViewModel.Navigator {

    private static final String TAG = "AgreementFragment";

    private static final String ARG_OAUTH_TOKEN = "ARG_OAUTH_TOKEN";

    private String mToken;
    private Callbacks mCallbacks;
    private FragmentAgreementBinding mFragmentAgreementBinding;
    private AgreementViewModel mAgreementViewModel;

    public static AgreementFragment getInstance(String token) {
        AgreementFragment fragment = new AgreementFragment();

        Bundle args = new Bundle();
        args.putString(ARG_OAUTH_TOKEN, token);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showMainActivity() {
        mCallbacks.onCallMainActivity();
    }


    public interface Callbacks {

        void onCallMainActivity();

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToken = getArguments().getString(ARG_OAUTH_TOKEN);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mFragmentAgreementBinding = FragmentAgreementBinding.inflate(inflater,container,false);

        mAgreementViewModel = new AgreementViewModel(mToken);
        mAgreementViewModel.setNavigator(this);
        mFragmentAgreementBinding.setAgreementViewModel(mAgreementViewModel);

        View root = mFragmentAgreementBinding.getRoot();

        return root;
    }


}
