package com.example.jetpackjava;

import androidx.lifecycle.LifecycleOwner;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jetpackjava.databinding.ActivityMain2Binding;
import com.example.network.ApiResponse;
import com.example.network.GetRequest;
import com.example.network.JsonCallback;

import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main2);
        LifecycleOwner lifecycleOwner = binding.getLifecycleOwner();

        binding.setUser(new User("afe","sf","123123123",12));
        GetRequest<WokerResponse> request = new GetRequest<>(
                "http://47.93.215.205:9095/api/homepage/GetSmallTypeById?typeId=5&userId=1044");
//        request.execute();
//        binding.setUser(new User(response.message,response.body.toString(),response.status+"",12));
        request.execute(new JsonCallback<WokerResponse>() {
            @Override
            public void onSuccess(ApiResponse<WokerResponse> response) {
                super.onSuccess(response);
                binding.setUser(new User(response.body.getData().toString(),response.body.toString(),response.status+"",12));
            }
        });

    }
}