package com.ixuea.coures.kanmeitu.avtivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.ixuea.coures.kanmeitu.MainActivity;
import com.ixuea.coures.kanmeitu.R;
import com.ixuea.coures.kanmeitu.util.SharedPreferencesUtil;

public class SplashActivity extends BaseActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            next();
        }
    };

    private void next() {

        Intent intent = null;
        if (sp.isLogin()){
            intent = new Intent(this, MainActivity.class);
        }else {
            intent = new Intent(this,LoginActivity.class);
        }
        startActivity(intent);
        //关闭当前界面
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },3000);


    }
}
