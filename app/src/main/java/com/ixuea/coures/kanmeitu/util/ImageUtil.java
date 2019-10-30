package com.ixuea.coures.kanmeitu.util;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ixuea.coures.kanmeitu.R;

public class ImageUtil {

    public static void show(Activity activity, ImageView imageView,String uri){
        RequestOptions options = getCommonRequestOptions();
        Glide.with(activity).load(uri).apply(options).into(imageView);
    }

    private static RequestOptions getCommonRequestOptions() {
        RequestOptions options = new RequestOptions();

        options.placeholder(R.drawable.ic_place_holder);

        options.error(R.drawable.ic_place_holder);
        options.centerCrop();

        return options;

    }
}
