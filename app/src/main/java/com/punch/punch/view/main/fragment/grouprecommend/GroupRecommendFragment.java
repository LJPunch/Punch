package com.punch.punch.view.main.fragment.grouprecommend;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punch.punch.R;

public class GroupRecommendFragment extends Fragment {

    private Callbacks mCallbacks;

    public interface Callbacks{
        void attachMainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a;

        if(context instanceof Activity){
            a = (Activity) context;
            if(a instanceof Callbacks)
                mCallbacks = (Callbacks) a;
        }
    }

    public static GroupRecommendFragment newInstance(){
        GroupRecommendFragment groupRecommendFragment = new GroupRecommendFragment();
        return groupRecommendFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_grouprecommend, container , false);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if(mCallbacks != null)
            mCallbacks = null;
    }
}
