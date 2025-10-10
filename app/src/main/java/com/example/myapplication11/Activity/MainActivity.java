package com.example.myapplication11.Activity;// 导入必要的包
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication11.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

// 继承 AppCompatActivity
public class MainActivity extends AppCompatActivity {
    // Activity 创建时调用（生命周期第一步）
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        //getFragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //get NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView3);
        //get NavController
        NavController navController = navHostFragment.getNavController();
        //configure the AppBar
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.firstFragment2,
                R.id.secondFragment2,
                R.id.thirdFragment2
        ).build();
        //set the configure
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
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