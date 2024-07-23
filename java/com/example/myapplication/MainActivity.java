package com.example.myapplication;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;

    private MediaPlayer mediaPlayer = null;
    private boolean isRelease = true; //判断MediaPlayer是否释放的标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//加载布局文件(xml)
        initView(); //初始化控件
    }

    private void initView() {
        button1 = (Button) findViewById(R.id.button1);//根据id名称获取控件(button )
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        //



        button1.setOnClickListener(this);//设置监听
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button3.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1: //播放
                if (isRelease){
                    //在raw下的资源
                    mediaPlayer = MediaPlayer.create(this,R.raw.m3);
                    isRelease = false;
                }
                mediaPlayer.start(); //开始播放
                Toast toast1=Toast.makeText(MainActivity.this,"正在播放《This Wish》",Toast.LENGTH_LONG);
                toast1.setGravity(Gravity.TOP | Gravity.LEFT,200,500);
                toast1.show();
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(true);
                break;

            case R.id.button2: //播放
                if (isRelease){
                    //在raw下的资源
                    mediaPlayer = MediaPlayer.create(this,R.raw.m4);
                    isRelease = false;
                }
                mediaPlayer.start(); //开始播放
                Toast toast2=Toast.makeText(MainActivity.this,"正在播放《At All Costs》",Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.TOP | Gravity.LEFT,200,500);
                toast2.show();
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(true);
                break;

            case R.id.button3:
                mediaPlayer.reset(); //重置MediaPlayer
                mediaPlayer.release(); //释放MediaPlayer
                isRelease = true;
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(false);
                break;
        }
    }
}