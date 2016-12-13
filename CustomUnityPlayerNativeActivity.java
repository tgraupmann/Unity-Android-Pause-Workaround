package com.tagenigma.example;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import com.prime31.ActivityProxyObjectHelper;

public class CustomUnityPlayerNativeActivity extends CustomUnityPlayerActivity {
    private CustomActivityProxyObjectHelper _proxyHelper;

    public CustomUnityPlayerNativeActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this._proxyHelper = new CustomActivityProxyObjectHelper(this);
            this._proxyHelper.onCreate(savedInstanceState);
        } catch (Exception var3) {
            Log.i("Prime31", "Failed to create proxyHelper: " + var3.getMessage());
        }

    }

    protected void onActivityResult(int request, int response, Intent data) {
        super.onActivityResult(request, response, data);
        this._proxyHelper.onActivityResult(request, response, data);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
        this._proxyHelper.onNewIntent(intent);
    }

    protected void onStart() {
        super.onStart();
        this._proxyHelper.invokeZeroParameterMethod("onStart");
    }

    protected void onStop() {
        super.onStop();
        this._proxyHelper.invokeZeroParameterMethod("onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        this._proxyHelper.invokeZeroParameterMethod("onDestroy");
    }

    protected void onRestart() {
        super.onRestart();
        this._proxyHelper.invokeZeroParameterMethod("onRestart");
    }

    public void onPause() {
        super.onPause();
        //this._proxyHelper.invokeZeroParameterMethod("onPause");
    }

    public void onPauseDelayed() {
        super.onPauseDelayed();
        this._proxyHelper.invokeZeroParameterMethod("onPause");
    }

    public void onResume() {
        super.onResume();
        this._proxyHelper.invokeZeroParameterMethod("onResume");
    }

    public void onBackPressed() {
        super.onBackPressed();
        this._proxyHelper.invokeZeroParameterMethod("onBackPressed");
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        this._proxyHelper.onSaveInstanceState(savedInstanceState);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this._proxyHelper.onRestoreInstanceState(savedInstanceState);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this._proxyHelper.onConfigurationChanged(newConfig);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this._proxyHelper.onWindowFocusChanged(hasFocus);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        this._proxyHelper.onKeyDown(keyCode, event);
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        this._proxyHelper.onKeyUp(keyCode, event);
        return super.onKeyUp(keyCode, event);
    }

    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        this._proxyHelper.onTrimMemory(level);
    }
}
