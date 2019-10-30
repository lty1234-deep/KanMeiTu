package com.ixuea.coures.kanmeitu.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;
import com.ixuea.coures.kanmeitu.R;
import com.ixuea.coures.kanmeitu.util.Contants;
import com.ixuea.coures.kanmeitu.util.ImageUtil;

public class ImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        PhotoView pv = findViewById(R.id.pv);
        String uri = getIntent().getStringExtra(Contants.ID);

        ImageUtil.show(this,pv,uri);
    }
}
