package com.example.myapplication11.Component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.google.android.material.button.MaterialButton;

public class MyButton extends MaterialButton implements DefaultLifecycleObserver {
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onPause(owner);
        // 1. 创建 Toast 对象
        Toast toast = Toast.makeText(getContext(), "呜呜呜 快回来", Toast.LENGTH_SHORT);
        // 3. 显示 Toast
        toast.show();
    }
}
