package com.blue.helloso.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.blue.helloso.ServerManager;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyService extends Service {
    private static final String TAG = "BlueTeam";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: MyService");
        new Thread(){
            @Override
            public void run() {
                super.run();
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getByName("0.0.0.0");
                    Log.d(TAG,"onCreate: " + inetAddress.getHostAddress());
                    ServerManager serverManager = new ServerManager(getApplicationContext(), inetAddress, 8005);
                    serverManager.startServer();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
