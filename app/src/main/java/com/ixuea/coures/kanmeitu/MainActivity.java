package com.ixuea.coures.kanmeitu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ixuea.coures.kanmeitu.adapter.ImageDetailActivity;
import com.ixuea.coures.kanmeitu.adapter.imageAdapter;
import com.ixuea.coures.kanmeitu.api.Api;
import com.ixuea.coures.kanmeitu.avtivity.BaseActivity;
import com.ixuea.coures.kanmeitu.avtivity.LoginActivity;
import com.ixuea.coures.kanmeitu.domain.Image;
import com.ixuea.coures.kanmeitu.domain.response.ListResponse;
import com.ixuea.coures.kanmeitu.util.Contants;
import com.ixuea.coures.kanmeitu.util.SharedPreferencesUtil;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    private imageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rv.setLayoutManager(layoutManager);

        ArrayList<Image>  datas = new ArrayList<>();
        for (int i = 1;i < 10;i++){
            datas.add(new Image(String.format("http://dev-courses-quick.oss-cn-beijing.aliyuncs.com/%d.jpg",i)));
        }

        adapter = new imageAdapter(this);
        adapter.setOnItemClickListener(new imageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                Toast.makeText(MainActivity.this,"click:"+position,Toast.LENGTH_SHORT).show();
                Image image = adapter.getData(position);

                Intent intent = new Intent(MainActivity.this, ImageDetailActivity.class);
                intent.putExtra(Contants.ID,image.getUri());
                startActivity(intent);
            }
        });
        rv.setAdapter(adapter);

        adapter.setDatas(datas);

    }

    private void fetchData() {
        //这里涉及到很多知识，可以够讲几门课程了
        //在这里大家只需简单理解，这样写就能请求到数据就行了
        Api
                .getInstance()
                .images()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListResponse<Image>>(){
                    @Override
                    public void onSubscribe(Disposable d) {

                    }



                    @Override
                    public void onNext(ListResponse<Image> imageListResponse) {
                        //当数据请求完毕后，他会解析成对象，并返回给我们
                        //真实项目中还会进行一系列的错误处理

                        //请参考我们的《Android开发项目实战之我的云音乐》课程
                        //http://www.ixuea.com/courses/10
                        adapter.setDatas(imageListResponse.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        //真实项目中会将错误，提示给用户
                        //同时写到日志
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void onLogoutClick(View view){
        sp.setLogin(false);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        finish();
    }
}
