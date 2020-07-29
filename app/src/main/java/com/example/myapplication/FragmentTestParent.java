package com.example.myapplication;



import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class FragmentTestParent extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test1, container,false);
        FragmentManager fm = getChildFragmentManager();
        FragmentTestChilde testParent = new FragmentTestChilde();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.fragment1111, testParent);
        transaction.commitAllowingStateLoss();
        return view;
    }

    @Override
    public void onPause() {
        Log.e("tag","onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("tag","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("tag","onDestroyView");
    }
}
