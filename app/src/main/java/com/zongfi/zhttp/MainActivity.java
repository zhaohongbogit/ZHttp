package com.zongfi.zhttp;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.zongfi.zhttp.network.OkHttpStack;

import java.util.HashMap;

import javax.net.ssl.SSLSocketFactory;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_msg1)
    TextView msgTextView;
    @Bind(R.id.collapsing_tollbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"你看啥你看啥！",Snackbar.LENGTH_SHORT).show();
//                OkHttpStack okHttpStack = new OkHttpStack();
//                RequestQueue volley = Volley.newRequestQueue(MainActivity.this, okHttpStack);
//                volley.start();
            }
        });
        collapsingToolbarLayout.setTitle("您看啥");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void requestData(){
        //TODO http://www.chinaz.com/web/2015/0731/428907.shtml
        String[] hosts = {"kyfw.12306.cn"};
        int[] certRes = {R.raw.kyfw};
        String[] certPass = {"asdfqaz"};
        HashMap<Object, Object> socketFactoryMap = new HashMap<>(hosts.length);
        for(int i=0;i<certRes.length;i++){
            int res = certRes[i];
            String password = certPass[i];
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
