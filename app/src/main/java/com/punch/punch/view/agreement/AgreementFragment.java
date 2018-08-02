package com.punch.punch.view.agreement;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.punch.punch.R;


public class AgreementFragment extends Fragment implements AgreementContract.View {

    private static final String TAG = "AgreementFragment";

    private static final String ARG_OAUTH_TOKEN = "ARG_OAUTH_TOKEN";

    private String mToken;
    private AgreementContract.Presenter mPresenter;
    private Callbacks mCallbacks;

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

    @Override
    public void setPresenter(AgreementContract.Presenter presenter) {
        this.mPresenter = presenter;
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

    @Override
    public void onStart() {
        super.onStart();

        AgreementContract.Presenter presenter = new AgreementPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_agreement, null);

        Button signupButton = root.findViewById(R.id.button_signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.registAgreement(mToken, null);
            }
        });

        return root;
    }


}
