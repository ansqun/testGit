package com.ansqun.test;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    boolean flag = BuildConfig.testFlag;

    Gson mGson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: flag = [" + flag + "]");
        setContentView(R.layout.activity_main);
        String buildTime = getString(R.string.build_time);
        Log.d(TAG, "onCreate: buildTime = [" + buildTime + "]");

        ActivityManager am = (ActivityManager) getSystemService(Activity.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(memoryInfo);
        long totalMem = memoryInfo.totalMem;

        Debug.MemoryInfo osMemoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(osMemoryInfo);
        int pss = osMemoryInfo.dalvikPss;

        long VMHeapSize = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        long AllocateVMMemorySize = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
        long VMHeapSizeLimit = Runtime.getRuntime().maxMemory() / (1024 * 1024);

        registerComponentCallbacks(new ComponentCallbacks() {
            @Override
            public void onConfigurationChanged(Configuration newConfig) {

            }

            @Override
            public void onLowMemory() {

            }
        });
    }

}
