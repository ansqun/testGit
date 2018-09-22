package com.ansqun.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    boolean flag = BuildConfig.testFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: flag = [" + flag + "]");
        setContentView(R.layout.activity_main);
        String buildTime = getString(R.string.build_time);
        Log.d(TAG, "onCreate: buildTime = [" + buildTime + "]");
    }
}
