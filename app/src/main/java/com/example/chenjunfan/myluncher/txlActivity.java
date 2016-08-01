package com.example.chenjunfan.myluncher;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenjunfan on 16/8/1.
 */
public class txlActivity  extends Activity implements AdapterView.OnItemClickListener{
    List<Map<String,String>> dataList= new ArrayList<Map<String, String>>();
    ListView mainLV;
    SimpleAdapter adapter;
    ProgressDialog prodialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonxunlu);

        prodialog=new ProgressDialog(txlActivity.this);
        prodialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        prodialog.setIndeterminate(true);
        prodialog.setCancelable(false);
        prodialog.setMessage("正在加载通讯录");
        prodialog.show();
        mainLV= (ListView) findViewById(R.id.listView);
        adapter=new SimpleAdapter(this,dataList,R.layout.tongxunlu_item,new String[]{"name","num"},new int[]{R.id.tv_name,R.id.tv_num});

        getdata();
        mainLV.setAdapter(adapter);
        mainLV.setOnItemClickListener(this);





    }


    public void getdata()
    {
         Thread t = new Thread(new Runnable() {
             @Override
             public void run() {
                 ContentResolver cr = getContentResolver();
//取得电话本中开始一项的光标
                 Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
//向下移动光标
                 while(cursor.moveToNext()){
                     Map<String, String> map=new HashMap<>();
//取得联系人名字
                     int nameFieldColumnIndex = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
                     map.put("name", cursor.getString(nameFieldColumnIndex));
//取得电话号码
                     String ContactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                     Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + ContactId, null, null);
                     while(phone.moveToNext()){
                         String PhoneNumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                         map.put("num",PhoneNumber);

                     }
                     Message msg=new Message();
                     msg.obj=map;
                     handler.sendMessage(msg);
                 }
                 cursor.close();
                 unshowhandler.sendMessage(new Message());

             }
         });
        t.start();




            }




    android.os.Handler handler = new android.os.Handler()//更新适配器
    {

        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            dataList.add((Map<String, String>) msg.obj);
            adapter.notifyDataSetChanged();
            // HomeActivity.this.findViewById(R.id.load_layout).setVisibility(View.GONE);


        }

    };
    android.os.Handler unshowhandler = new android.os.Handler()//更新适配器
    {

        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);

            prodialog.cancel();
            // HomeActivity.this.findViewById(R.id.load_layout).setVisibility(View.GONE);


        }

    };


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String str="tel:"+dataList.get(i).get("num");
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(str));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newperson(View view)
    {
        Intent intent = new Intent();

        intent.setAction(Intent.ACTION_VIEW);

        intent.setData(Contacts.People.CONTENT_URI);

        startActivity(intent);
    }
}
