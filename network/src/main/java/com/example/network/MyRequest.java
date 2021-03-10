package com.example.network;

import android.util.Log;

import androidx.annotation.IntDef;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public abstract class MyRequest<T, R extends MyRequest> {
    protected String mUrl;
    private HashMap<String, String> headers = new HashMap<>();
    protected HashMap<String, Object> params = new HashMap<>();
    public static final int CACHE_ONLY = 1;//只访问本地缓存，本地不存在也不会发起网络请求
    public static final int CACHE_FIRST = 2;//先访问缓存在访问网络，成功后缓存到本地
    public static final int NET_ONLY = 3;//之访问服务器不做任何存储
    public static final int NET_CACHE = 4;//先访问访问网络,成功后缓存到本地
    private String cacheKey;
    private Type mType;
    private Class mCLaz;

    @IntDef({CACHE_ONLY, CACHE_FIRST, NET_ONLY, NET_CACHE})
    public @interface CacheStategy {

    }

    public MyRequest(String url) {
        mUrl = url;
    }

    public R addHeader(String key, String value) {
        headers.put(key, value);
        return (R) this;
    }

    public R addParam(String key, Object value) {
        //int String byte char
        try {
            Field type = value.getClass().getField("Type");
            Class o = (Class) type.get(null);//TODO
            if (o.isPrimitive()) {
                params.put(key, value);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (R) this;
    }

    public R cacheKey(String key) {
        this.cacheKey = key;
        return (R) this;
    }

    public void execute(JsonCallback<T> callback) {
        getCall().enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                ApiResponse<T> response = new ApiResponse<>();
                response.message = e.getMessage();
                callback.onError(response);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ApiResponse<T> response1 = parseResponse(response, callback);
                if (response1.success) {
                    callback.onSuccess(response1);
                } else {
                    callback.onError(response1);
                }
            }
        });
    }

    public ApiResponse<T> execute() {
        try {
            Response response = getCall().execute();
            ApiResponse<T> response1 = parseResponse(response, null);
            return response1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ApiResponse<T> parseResponse(Response response, JsonCallback<T> callback) {
        String message = null;
        int status = response.code();
        boolean success = response.isSuccessful();
        ApiResponse<T> result = new ApiResponse<>();
        Convert convert = ApiService.sConvert;
        try {
            String string = response.body().string();
            if (success) {
                if (callback != null) {
                    ParameterizedType type = (ParameterizedType) callback.getClass().getGenericSuperclass();
                    Type argument = type.getActualTypeArguments()[0];
                    result.body = (T) convert.convert(string, argument);
                } else if (mType != null) {
                    result.body = (T) convert.convert(string, mType);
                } else if (mType != null) {
                    result.body = (T) convert.convert(string, mCLaz);
                } else {
                    Log.e("MyRequest：", "parseResponse无法解析");
                }
            } else {
                message = string;
            }

        } catch (Exception e) {
            message = e.getMessage();
            success = false;
        }
        result.success = success;
        result.status = status;
        result.message = message;
        return result;
    }

    private R responseType(Type type) {
        mType = type;
        return (R) this;
    }

    private R responseType(Class type) {
        mCLaz = type;
        return (R) this;
    }


    protected Call getCall() {
        Request.Builder builder = new Request.Builder();
        addHeader(builder);
        Request request = generRequest(builder);
        Call call = ApiService.okHttpClient.newCall(request);
        return call;
    }

    protected abstract Request generRequest(Request.Builder builder);

    private void addHeader(Request.Builder builder) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }
}
