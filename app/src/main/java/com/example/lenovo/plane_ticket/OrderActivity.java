package com.example.lenovo.plane_ticket;

import android.app.Activity;
import android.database.DataSetObserver;
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
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bean.Info;
import global.Contants;

public class OrderActivity extends Activity {
    private ListView lv;
    List<Info> list = null;
    MyAdapter myAdapter = null;
    private Button btnfinish;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        list = new ArrayList<>();
        list.addAll(Contants.getList());
        myAdapter = new MyAdapter();
        lv = (ListView) findViewById(R.id.lv);
        btnfinish=(Button)findViewById(R.id.btn_finish);

        lv.setAdapter(myAdapter);
        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    class MyAdapter extends BaseAdapter {
        ViewHolder viewHolder = null;

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(OrderActivity.this, R.layout.lv_item, null);
                viewHolder = new ViewHolder();
                viewHolder.tvHb = convertView.findViewById(R.id.tv_hb);
                viewHolder.tvName = convertView.findViewById(R.id.tv_name);
                viewHolder.tvPlace = convertView.findViewById(R.id.tv_place);
                viewHolder.tvTime = convertView.findViewById(R.id.tv_time);
                viewHolder.btnDelete = convertView.findViewById(R.id.btn_delete);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tvHb.setText("航班： "+list.get(position).getHb());
            viewHolder.tvName.setText("姓名： "+list.get(position).getName());
            viewHolder.tvPlace.setText("目的地："+list.get(position).getPlace());
            viewHolder.tvTime.setText("时间："+list.get(position).getTime());

            viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Contants.removeData(list.get(position));
                    list.remove(position);
                    myAdapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }
    }

    class ViewHolder {
        TextView tvName;
        TextView tvHb;
        TextView tvPlace;
        TextView tvTime;
        Button btnDelete;
    }

}


