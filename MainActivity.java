package com.tagenigma.example;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends CustomUnityPlayerNativeActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final boolean sEnableLogging = false;

    @Override
    public void onPause() {
        if (sEnableLogging) {
            Log.d(TAG, "onPause:");
        }
        super.onPause();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.super.onPauseDelayed();
            }
        }, 50);
    }

    @Override
    public void onResume() {
        if (sEnableLogging) {
            Log.d(TAG, "onResume:");
        }
        super.onResume();
        if (null != mUnityPlayer) {
            if (sEnableLogging) {
                Log.d(TAG, "onResume: Resumed Unity");
            }
            mUnityPlayer.resume();
        }
    }
}
