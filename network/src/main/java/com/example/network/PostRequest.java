package com.example.network;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

public class PostRequest <T> extends MyRequest<T,PostRequest>{
    public PostRequest(String url) {
        super(url);
    }

    @Override
    protected Request generRequest(Request.Builder builder) {
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            bodyBuilder.add(entry.getKey(),String.valueOf(entry.getValue()));
        }
        Request build = builder.url(mUrl).post(bodyBuilder.build()).build();
        return build;
    }
}
