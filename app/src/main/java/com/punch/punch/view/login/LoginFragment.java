package com.punch.punch.view.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.punch.punch.R;
import com.punch.punch.view.BasePresenter;

public class LoginFragment extends Fragment implements LoginContract.View{

    private static final String TAG = "LoginFragment";
    private static final int RC_SIGN_IN = 9001;

    private LoginContract.Presenter mPresenter;
    private GoogleSignInClient mGoogleSignInClient;
    private Callbacks mCallbacks;

    public static LoginFragment getInstance(){
        LoginFragment fragment = new LoginFragment();

        return fragment;
    }

    public interface Callbacks{

        void onCallMainActivity();

        void onCallAgreementActivity(String token);

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
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

    }

    @Override
    public void onStart() {
        super.onStart();

        LoginContract.Presenter presenter = new LoginPresenter(this);

        // Check if the user is already signed in and all required scopes are granted
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());
        if (account != null && GoogleSignIn.hasPermissions(account, new Scope(Scopes.PROFILE))) {
            mPresenter.requestAuthentication(account.getId());
        } else {

        }

    }

    @Override
    public void onStop() {
        super.onStop();

        /**
         * 테스트를 위해 signOut 구현
         */
        mGoogleSignInClient.signOut().addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                // [START_EXCLUDE]

                // [END_EXCLUDE]
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login,null);
        root.findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignIn();
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(@Nullable Task<GoogleSignInAccount> completedTask) {
        Log.d(TAG, "handleSignInResult:" + completedTask.isSuccessful());

        try {
            // Signed in successfully, show authenticated U
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            mPresenter.requestAuthentication(account.getId());
        } catch (ApiException e) {
            // Signed out, show unauthenticated UI.
            Log.w(TAG, "handleSignInResult:error", e);
            showSignResult(false);
        }
    }

    @Override
    public void showSignIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void showSignResult(boolean isSuccess) {
        if(isSuccess)
            Toast.makeText(getContext(),"Login Success",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getContext(),"Login Fail",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMainActivity() {
        mCallbacks.onCallMainActivity();
    }

    @Override
    public void showAgreeActivity(String token) {
        mCallbacks.onCallAgreementActivity(token);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }


}
