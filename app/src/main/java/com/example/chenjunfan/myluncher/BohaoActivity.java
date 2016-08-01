package com.example.chenjunfan.myluncher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by chenjunfan on 16/8/1.
 */


public class BohaoActivity extends Activity {

    private TextView bohaoTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bohao);

        bohaoTV= (TextView) findViewById(R.id.tv_bohao);


    }

    public void shuru(View view)
    {
        String str= (String) bohaoTV.getText();
        switch (view.getId())
        {
            case R.id.btn_0:
                str=str+"0";
                bohaoTV.setText(str);
                break;
            case R.id.btn_1:
                str=str+"1";
                bohaoTV.setText(str);
                break;
            case R.id.btn_2:
                str=str+"2";
                bohaoTV.setText(str);
                break;
            case R.id.btn_3:
                str=str+"3";
                bohaoTV.setText(str);
                break;
            case R.id.btn_4:
                str=str+"4";
                bohaoTV.setText(str);
                break;
            case R.id.btn_5:
                str=str+"5";
                bohaoTV.setText(str);
                break;
            case R.id.btn_6:
                str=str+"6";
                bohaoTV.setText(str);
                break;
            case R.id.btn_7:
                str=str+"7";
                bohaoTV.setText(str);
                break;
            case R.id.btn_8:
                str=str+"8";
                bohaoTV.setText(str);
                break;
            case R.id.btn_9:
                str=str+"9";
                bohaoTV.setText(str);
                break;
            case R.id.btn_shan:
                if(!str.equals("")) {
                    str = str.substring(0, str.length() - 1);
                    bohaoTV.setText(str);
                }
                break;
            case R.id.btn_boda:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + str));
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
