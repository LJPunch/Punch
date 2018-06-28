package com.punch.punch.view.agreement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.punch.punch.R;
import com.punch.punch.view.login.LoginActivity;
import com.punch.punch.view.main.MainActivity;

public class AgreementActivity extends AppCompatActivity implements AgreementFragment.Callbacks{

    private static final String EXTRA_OAUTH_TOKEN = "com.punch.punch.view.agreement.EXTRA_OAUTH_TOKEN";

    public static Intent newIntent(Context packageContext, String token){
        Intent intent = new Intent(packageContext, AgreementActivity.class);
        intent.putExtra(EXTRA_OAUTH_TOKEN, token);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_agreement_fragment);

        if(fragment == null){
            String token = getIntent().getStringExtra(EXTRA_OAUTH_TOKEN);
            fragment = AgreementFragment.getInstance(token);
            fragmentManager.beginTransaction()
                    .add(R.id.container_agreement_fragment, fragment)
                    .commit();
        }
    }

    @Override
    public void onCallMainActivity() {
        Intent intent = MainActivity.newIntent(AgreementActivity.this);
        startActivity(intent);
    }
}
