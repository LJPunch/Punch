package com.punch.punch.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.punch.punch.R;
import com.punch.punch.view.agreement.AgreementActivity;
import com.punch.punch.view.login.LoginFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.Callbacks{

    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, MainActivity.class);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_main_fragment);

        if(fragment == null){
            fragment = MainFragment.getInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.container_main_fragment, fragment)
                    .commit();
        }
    }

    @Override
    public void onCallPersonalRecommend() {
        Toast.makeText(this,"click personal",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCallGroupRecommend() {
        Toast.makeText(this,"click group",Toast.LENGTH_SHORT).show();
    }
}
