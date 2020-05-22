package com.blue.helloso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blue.helloso.service.MyService;

import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "BlueTeam";
    private int version = Build.VERSION.SDK_INT;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI("你好"));
        try{
            InetAddress inetAddress = NetUtils.getLocalIPAddress();
            if(inetAddress != null){
                tv.setText(inetAddress.getHostAddress() + " version: " + version);
            }else {
                tv.setText("未获取到inetAddress" + "version: " + version);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(String str);

    public void operate(View view) {
        switch (view.getId()){
            case R.id.id_bt_index:
                //start Server：create --> launch --> destroy
                //if server has already created, following repeated launch, using the same server, not create again.
                Intent intent = new Intent(this, MyService.class);
                Log.d(TAG,"operate:button");
                startService(intent);
                ((Button)view).setText("服务已开启");
                break;
        }
    }
}
