package com.zongfi.zhttp.network;

import com.android.volley.toolbox.HurlStack;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/**
 * Created by ZHZEPHI on 2015/10/20.
 */
public class SelfSignSslOkHttpStack extends HurlStack {

    private OkHttpClient okHttpClient;

    private Map<String,SSLSocketFactory> socketFactoryMap;

    SelfSignSslOkHttpStack(Map<String,SSLSocketFactory> factoryMap){
        this(new OkHttpClient(),factoryMap);
    }

    public SelfSignSslOkHttpStack(OkHttpClient okHttpClient, Map<String, SSLSocketFactory> factoryMap) {
        this.okHttpClient = okHttpClient;
        this.socketFactoryMap = factoryMap;
    }

    @Override
    protected HttpURLConnection createConnection(URL url) throws IOException {
        if("https".equals(url.getProtocol()) && socketFactoryMap.containsKey(url.getHost())){
            HttpsURLConnection connection = (HttpsURLConnection) new OkUrlFactory(okHttpClient).open(url);
            connection.setSSLSocketFactory(socketFactoryMap.get(url.getHost()));
            return connection;
        }else{
            return new OkUrlFactory(okHttpClient).open(url);
        }
    }
}
