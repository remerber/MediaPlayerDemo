package com.example.myapplication;



import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class FragmentTestChilde extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView=new TextView(getActivity());
        textView.setText("2222222222222");
        return textView;
    }

    @Override
    public void onPause() {
        Log.e("tag","onPause222");
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("tag","onStop222");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("tag","onDestroyView222");
    }
}
