package com.example.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class FragmentTestAcitivity extends AppCompatActivity {
    private String TAG="tag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        FragmentManager fm = getFragmentManager();
        FragmentTestParent testParent = new FragmentTestParent();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.test_container, testParent);
        transaction.commit();

    }

//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//        if(KeyEvent.ACTION_DOWN==event.getAction()){
//            switch (event.getKeyCode()){
//                case KeyEvent.KEYCODE_ENTER:
//                    break;
//                case KeyEvent.KEYCODE_DPAD_CENTER:
//                    Log.e("Tag","你按下中间键");
//                    break;
//
//                case KeyEvent.KEYCODE_DPAD_DOWN:
//                    Log.e("Tag","你按下下方向键");
//                    break;
//
//                case KeyEvent.KEYCODE_DPAD_LEFT:
//                    Log.e("Tag","你按下左方向键");
//                    break;
//
//                case KeyEvent.KEYCODE_DPAD_RIGHT:
//                    Log.e("Tag","你按下右方向键");
//                    break;
//
//                case KeyEvent.KEYCODE_DPAD_UP:
//                    Log.e("Tag","你按下上方向键");
//
//            }
//        }
//        return super.dispatchKeyEvent(event);
//    }


}
