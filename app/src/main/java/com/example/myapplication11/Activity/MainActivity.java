package com.example.myapplication11.Activity;// 导入必要的包
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication11.R;
// 继承 AppCompatActivity
public class MainActivity extends AppCompatActivity {
    // Activity 创建时调用（生命周期第一步）
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //启动
    @Override
    protected void onStart() {
        super.onStart();
    }
    //继续
    @Override
    protected void onResume() {
        super.onResume();
    }
    //暂停
    @Override
    protected void onPause() {
        super.onPause();
    }
    //停止
    @Override
    protected void onStop() {
        super.onStop();
        //保存到本地
    }
    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}