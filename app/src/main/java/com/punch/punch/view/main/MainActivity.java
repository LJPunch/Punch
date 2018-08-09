package com.punch.punch.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.punch.punch.R;
import com.punch.punch.view.main.fragment.grouprecommend.GroupRecommendFragment;
import com.punch.punch.view.main.fragment.main.MainFragment;
import com.punch.punch.view.main.fragment.personalrecommend.PersonalRecommendFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.Callbacks , PersonalRecommendFragment.Callbacks , GroupRecommendFragment.Callbacks{

    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attachMainFragment();
    }

    @Override
    public void attachMainFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_main_fragment);

        if(fragment == null){
            fragment = MainFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.container_main_fragment, fragment)
                    .commit();
        }
    }

    @Override
    public void attachPersonalRecommendFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_main_fragment);

        if(fragment == null){
            fragment = PersonalRecommendFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.container_main_fragment, fragment)
                    .commit();
        }
    }

    @Override
    public void attachGroupRecommendFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_main_fragment);

        if(fragment == null){
            fragment = GroupRecommendFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.container_main_fragment, fragment)
                    .commit();
        }
    }
}
