package com.example.chenjunfan.myluncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button chenboBT, yuequnBT, chenjunfanBT, zhangmeifenBT, yueminBT, xiaoyinBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    public void initview() {
        chenboBT = (Button) findViewById(R.id.btn_chenbo);
        yuequnBT = (Button) findViewById(R.id.btn_yuequn);
        chenjunfanBT = (Button) findViewById(R.id.btn_chenjunfan);
        zhangmeifenBT = (Button) findViewById(R.id.btn_zhangmeifen);
        yueminBT = (Button) findViewById(R.id.btn_yuemin);
        xiaoyinBT = (Button) findViewById(R.id.btn_xiaoyin);

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


}




