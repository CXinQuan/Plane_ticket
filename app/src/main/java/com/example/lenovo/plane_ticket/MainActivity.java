package com.example.lenovo.plane_ticket;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.IDNA;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bean.Info;
import global.Contants;

public class MainActivity extends Activity {
    private EditText etName;
    private EditText et_place;
    private Spinner hb;
    private Spinner time;
    private Button btnAdd;
    private Button btnfinish;
    Info info = null;
    String[] str_time = {"00:00", "01:00",
            "02:00", "03:00",
            "04:00", "05:00",
            "06:00", "07:00",
            "08:00", "09:00"
            , "10:00", "11:00"
            , "12:00", "13:00",
            "14:00", "15:00",
            "16:00", "17:00",
            "18:00", "19:00"
            , "20:00", "21:00"
            , "22:00", "23:00"};
    String[] str_hb = {"HB223", "KH3880", "CC3410", "AK3996", "MN5545", "KL8786"};

    private void initView() {
        etName = (EditText) findViewById(R.id.et_name);
        et_place = (EditText) findViewById(R.id.et_place);
        hb = (Spinner) findViewById(R.id.hb);
        time = (Spinner) findViewById(R.id.time);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnfinish=(Button)findViewById(R.id.btn_finish);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        info = new Info();
        time.setAdapter(new TimeAdapter());
        hb.setAdapter(new HBAdapter());
        time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             //   Toast.makeText(MainActivity.this, str_time[position], Toast.LENGTH_SHORT).show();
                info.setTime(str_time[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        hb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             //   Toast.makeText(MainActivity.this, str_hb[position], Toast.LENGTH_SHORT).show();
                info.setHb(str_hb[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().trim().equals("") ||
                        et_place.getText().toString().trim().equals("") ||
                        info.getHb().equals("") || info.getHb().equals(null)
                        || info.getTime().equals("") || info.getTime().equals(null)) {
                    Toast.makeText(MainActivity.this, "请填写必填项！", Toast.LENGTH_SHORT).show();
                    return;
                }
                info.setName(etName.getText().toString().trim());
                info.setPlace(et_place.getText().toString().trim());
                Contants.addData(info);
                etName.setText("");
                et_place.setText("");
                Toast.makeText(MainActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class TimeAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return str_time.length;
        }

        @Override
        public Object getItem(int position) {
            return str_time[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(str_time[position] + "");
            return textView;
        }
    }

    class HBAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return str_hb.length;
        }

        @Override
        public Object getItem(int position) {
            return str_hb[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(str_hb[position] + "");
            return textView;
        }
    }


}
