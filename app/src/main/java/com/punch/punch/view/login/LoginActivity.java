package com.punch.punch.view.login;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.punch.punch.R;
import com.punch.punch.view.agreement.AgreementActivity;
import com.punch.punch.view.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginFragment.Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_login_fragment);

        if(fragment == null){
            fragment = LoginFragment.getInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.container_login_fragment, fragment)
                    .commit();
        }
    }

    @Override
    public void onCallMainActivity() {
        Intent intent = MainActivity.newIntent(LoginActivity.this);
        startActivity(intent);
    }

    @Override
    public void onCallAgreementActivity(String token) {
        Intent intent = AgreementActivity.newIntent(LoginActivity.this, token);
        startActivity(intent);
    }
}
