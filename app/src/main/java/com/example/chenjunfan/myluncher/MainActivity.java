package com.example.chenjunfan.myluncher;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupWindow.OnDismissListener {
    Button chenboBT, yuequnBT, chenjunfanBT, zhangmeifenBT, yueminBT, xiaoyinBT,bohaoBT,allnumBT,takeBT,watchBT,xiangqiBT;
    TextView timeTV;
    LayoutInflater inflater = null;
    View popview = null;
    PopupWindow pop = null;
    Button yesBT=null,noBT=null;
    TextView titleTV = null;
    String str = null;

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
        takeBT = (Button) findViewById(R.id.btn_takephotos);
        watchBT = (Button) findViewById(R.id.btn_watchphotos);
        xiangqiBT = (Button) findViewById(R.id.btn_xiangqi);

        chenboBT.setOnClickListener(MainActivity.this);
        yuequnBT.setOnClickListener(MainActivity.this);
        chenjunfanBT.setOnClickListener(MainActivity.this);
        zhangmeifenBT.setOnClickListener(MainActivity.this);
        yueminBT.setOnClickListener(MainActivity.this);
        xiaoyinBT.setOnClickListener(MainActivity.this);
        takeBT.setOnClickListener(this);
        watchBT.setOnClickListener(this);
        xiangqiBT.setOnClickListener(this);

        inflater = LayoutInflater.from(this);
        popview = inflater.inflate(R.layout.popwindow_call,null);
        yesBT = (Button) popview.findViewById(R.id.BT_popc_yes);
        noBT = (Button) popview.findViewById(R.id.BT_popc_no);
        titleTV = (TextView) popview.findViewById(R.id.TV_popc_title);
        yesBT.setOnClickListener(this);
        noBT.setOnClickListener(this);


        pop = new PopupWindow(popview, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,false);

        pop.setBackgroundDrawable(new BitmapDrawable());

        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        pop.setOnDismissListener(this);

        pop.setOnDismissListener(this);


    }



    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.btn_chenbo:
               str="13987382571";
                titleTV.setText("拨打 陈波 的电话？");
                pop.showAtLocation(popview, Gravity.CENTER_HORIZONTAL,0,0);
                backgroundAlpha(0.5f);
                break;
            case R.id.btn_yuequn:
                str="13987382572";
                titleTV.setText("拨打 岳群 的电话？");
                pop.showAtLocation(popview, Gravity.CENTER_HORIZONTAL,0,0);
                backgroundAlpha(0.5f);
                break;
            case R.id.btn_zhangmeifen:
                str="15334375440";
                titleTV.setText("拨打 张美芬 的电话？");
                pop.showAtLocation(popview, Gravity.CENTER_HORIZONTAL,0,0);
                backgroundAlpha(0.5f);
                break;
            case R.id.btn_chenjunfan:
                str="18512527741";
                titleTV.setText("拨打 陈俊帆 的电话？");
                pop.showAtLocation(popview, Gravity.CENTER_HORIZONTAL,0,0);
                backgroundAlpha(0.5f);
                break;
            case R.id.btn_yuemin:
                str="13577340615";
                titleTV.setText("拨打 岳悯 的电话？");
                pop.showAtLocation(popview, Gravity.CENTER_HORIZONTAL,0,0);
                backgroundAlpha(0.5f);
                break;
            case R.id.btn_xiaoyin:
                str="13987393070";
                titleTV.setText("拨打 尹春伟 的电话？");
                pop.showAtLocation(popview, Gravity.CENTER_HORIZONTAL,0,0);
                backgroundAlpha(0.5f);
                break;
            case R.id.BT_popc_yes:
                pop.dismiss();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + str));
               // Toast.makeText(this, "press yes", Toast.LENGTH_SHORT).show();
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.BT_popc_no:
                //Toast.makeText(this, "press no", Toast.LENGTH_SHORT).show();
                pop.dismiss();
                break;
            case R.id.btn_takephotos:
                try
                {
                    Intent intent_takephotos = new Intent();
                    intent_takephotos.setClassName("com.android.gallery3d","com.android.camera.CameraLauncher");
                    startActivity(intent_takephotos);
                }
                catch (Exception e)
                {
                    Toast.makeText(this, "打开照相机失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_watchphotos:
                try{
                    Intent intent_watchphotos = new Intent();
                    intent_watchphotos.setClassName("com.android.gallery3d","com.android.gallery3d.app.GalleryActivity");
                    startActivity(intent_watchphotos);
                }
                catch (Exception e)
                {
                    Toast.makeText(this, "打开相册失败", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_xiangqi:
                try{
                    Intent intent_xiangqi = new Intent();
                    intent_xiangqi.setClassName("com.cnvcs.xiangqi","com.cnvcs.App");
                    startActivity(intent_xiangqi);
                }
                catch (Exception e)
                {
                    Toast.makeText(this, "打开象棋失败", Toast.LENGTH_SHORT).show();
                }
                break;





        }



    }



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


    @Override
    public void onDismiss() {
        backgroundAlpha(1f);
    }
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
}




