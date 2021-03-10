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
        GetRequest<JSONObject> request = new GetRequest<>("http://c.3g.163.com/nc/video/list/VAP4BFR16/y/0-10.html");
//        request.execute();
        request.execute(new JsonCallback<JSONObject>() {
            @Override
            public void onSuccess(ApiResponse<JSONObject> response) {
                super.onSuccess(response);
                binding.setUser(new User(response.message,response.body.toString(),response.status+"",12));
            }
        });
    }
}