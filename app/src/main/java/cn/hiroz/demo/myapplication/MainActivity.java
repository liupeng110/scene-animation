package cn.hiroz.demo.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

//5.0+ 版本 activity切换无缝动画  共享view 
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImagesAdapter adapter = new ImagesAdapter() {
            @Override @SuppressLint("NewApi")
            protected void onClickItem(View v, int position) {
                ViewerActivity.launch(MainActivity.this, v, data.get(position).resId);
            }
        };

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.content);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
