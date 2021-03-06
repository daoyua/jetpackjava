package com.example.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;

public class JsonConvert implements Convert{
    @Override
    public Object convert(String response, Type type) {
        JSONObject jsonObject = JSON.parseObject(response);
        JSONArray data = jsonObject.getJSONArray("data");
//        JSONObject data = jsonObject.getJSONObject("data");
        if(data!=null){
//            Object data1 = data.get("data");
           return JSON.parseObject(data.toString(),type);
        }
        return JSON.parseObject(jsonObject.toString(),type);
    }

    @Override
    public Object convert(String response, Class claz) {
        JSONObject jsonObject = JSON.parseObject(response);
        JSONObject data = jsonObject.getJSONObject("data");
        if(data!=null){
            Object data1 = data.get("data");
            return JSON.parseObject(data1.toString(),claz);
        }
        return JSON.parseObject(jsonObject.toString(),claz);
    }
}
