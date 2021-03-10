package com.example.network;

import okhttp3.Request;

public class GetRequest<T> extends MyRequest<T,GetRequest> {
    public GetRequest(String url) {
        super(url);
    }

    @Override
    protected Request generRequest(Request.Builder builder) {
        Request request = builder.get().url(UrlCreator.createUrlFromParams(mUrl, params)).build();
        return request;
    }
}
