package com.ixuea.coures.kanmeitu.avtivity;

import androidx.appcompat.app.AppCompatActivity;

import com.ixuea.coures.kanmeitu.util.SharedPreferencesUtil;

public class BaseActivity extends AppCompatActivity {

    protected SharedPreferencesUtil sp;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        sp = SharedPreferencesUtil.getInstance(getApplicationContext());
    }
}
