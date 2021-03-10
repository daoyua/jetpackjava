package com.example.jetpackjava;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class LifeCycleTest implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        System.out.println("create");
        Log.d("TAG", "create");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        System.out.println("onStart");
        Log.d("TAG", "onStart");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        System.out.println("onResume");
        Log.d("TAG", "onResume");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        System.out.println("onPause");
        Log.d("TAG", "onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
        System.out.println("onStop");
        Log.d("TAG", "onStop生命周期回调");
    }
}
