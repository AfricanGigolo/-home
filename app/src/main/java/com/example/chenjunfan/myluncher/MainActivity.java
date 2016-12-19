package com.example.chenjunfan.myluncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button chenboBT, yuequnBT, chenjunfanBT, zhangmeifenBT, yueminBT, xiaoyinBT,bohaoBT,allnumBT;
    TextView timeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        refreshTime();
    }

    public void initview() {
        chenboBT = (Button) findViewById(R.id.btn_chenbo);
        yuequnBT = (Button) findViewById(R.id.btn_yuequn);
        chenjunfanBT = (Button) findViewById(R.id.btn_chenjunfan);
        zhangmeifenBT = (Button) findViewById(R.id.btn_zhangmeifen);
        yueminBT = (Button) findViewById(R.id.btn_yuemin);
        xiaoyinBT = (Button) findViewById(R.id.btn_xiaoyin);
        bohaoBT = (Button) findViewById(R.id.btn_bohao);
        allnumBT= (Button) findViewById(R.id.btn_allnum);
        timeTV = (TextView) findViewById(R.id.TV_time);

        chenboBT.setOnClickListener(MainActivity.this);
        yuequnBT.setOnClickListener(MainActivity.this);
        chenjunfanBT.setOnClickListener(MainActivity.this);
        zhangmeifenBT.setOnClickListener(MainActivity.this);
        yueminBT.setOnClickListener(MainActivity.this);
        xiaoyinBT.setOnClickListener(MainActivity.this);


    }



    @Override
    public void onClick(View view) {
        Message msg=new Message();

        switch (view.getId()) {
            case R.id.btn_chenbo:
                msg.obj="13987382571";
                break;
            case R.id.btn_yuequn:
                msg.obj="13987382572";
                break;
            case R.id.btn_zhangmeifen:
                msg.obj="15334375440";
                break;
            case R.id.btn_chenjunfan:
                msg.obj="18512527741";
                break;
            case R.id.btn_yuemin:
                msg.obj="13577340615";
                break;
            case R.id.btn_xiaoyin:
                msg.obj="13987393070";
                break;


        }

        handlercall.sendMessage(msg);


    }

    Handler handlercall = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + msg.obj));
            try {
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    };

    public  void bohao(View view)
    {

       Intent intent = new Intent(MainActivity.this,BohaoActivity.class);
        startActivity(intent);

    }
    public void presstime(View view)
    {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_CALL_BUTTON);
        startActivity(intent);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {	return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void allnumber(View view)
    {
        Intent intent = new Intent(MainActivity.this,txlActivity.class);

        startActivity(intent);
    }

    Handler handlertime = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日\n EEEE HH点mm分ss秒 ");
            timeTV.setText(sd.format(new Date()));


        }


    };

    public void refreshTime()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(100);
                        handlertime.sendMessage(new Message());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

    }


}




