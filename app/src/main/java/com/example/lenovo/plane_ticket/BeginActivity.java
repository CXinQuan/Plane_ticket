package com.example.lenovo.plane_ticket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeginActivity extends Activity {
    Button btn_add;
    Button btn_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_query = (Button) findViewById(R.id.btn_query);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeginActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
    }
}
