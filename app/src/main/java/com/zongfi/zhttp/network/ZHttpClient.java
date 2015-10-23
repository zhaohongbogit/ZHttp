package com.zongfi.zhttp.network;

import android.content.Context;

import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ZHZEPHI on 2015/10/23 19:10.
 */
public class ZHttpClient {

    private static ZHttpClient mInstance;
    private OkHttpStack okHttpStack;
    Context context;

    private ZHttpClient(Context context){
        this.context = context;
        okHttpStack = new OkHttpStack();
        try {
            okHttpStack.setCertificates(context.getAssets().open("srca.cer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取网络请求实例
     * @return
     */
    public static ZHttpClient getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ZHttpClient.class) {
                if (mInstance == null) {
                    mInstance = new ZHttpClient(context);
                }
            }
        }
        return mInstance;
    }

    public void exec(String url){
        try {
            okHttpStack.createConnection(new URL(url));
            Volley.newRequestQueue(context,okHttpStack);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
