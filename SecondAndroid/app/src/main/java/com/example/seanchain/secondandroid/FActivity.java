package com.example.seanchain.secondandroid;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by seanchain on 1/28/16.
 */
public class FActivity extends Activity{
    private Context context;
    private Button btn1;
    private Button btn2;
    private TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);
        btn1 = (Button) findViewById(R.id.button1_first);
        btn2 = (Button) findViewById(R.id.button2_second);
        tx = (TextView) findViewById(R.id.textView);
        context = this;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data", "The data is hola");
                startActivity(intent);
            }
        });

        /*通过startActivityForResult*/

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                /*第一个参数是intent对象，第二个参数是请求的一个标志*/
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            String str = data.getStringExtra("data");
            tx.setText(str);
        }
    }
}
