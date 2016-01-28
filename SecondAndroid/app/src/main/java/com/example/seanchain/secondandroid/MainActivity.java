package com.example.seanchain.secondandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbx;
    private RadioGroup rgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbx = (CheckBox) findViewById(R.id.cbx);
        rgr = (RadioGroup) findViewById(R.id.rgr);
        rgr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.hola) Log.i("radio", "hola");
                else if (checkedId == R.id.hola1) Log.i("radio", "hola1");
                else Log.i("radio", "hola2");
            }
        });
        cbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    String str = cbx.getText().toString();
                    Log.i("checkbox", "The checkbox is on" + str);
                }
            }
        });
    }
}
