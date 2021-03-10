package com.example.jetpackjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jetpackjava.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {
   public ActivityMain3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        binding=ActivityMain3Binding.inflate(getLayoutInflater());

    }
}