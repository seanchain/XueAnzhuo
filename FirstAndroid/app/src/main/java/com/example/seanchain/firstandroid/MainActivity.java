package com.example.seanchain.firstandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private ImageButton loginButton;
    private AutoCompleteTextView acView;
    private MultiAutoCompleteTextView macView;
    private ToggleButton tgbtn;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 将布局xml文件引入到activity之中

        String cities[] = {"beijing1", "beijing2", "beijing3", "shanghai1", "shanghai2"};

        // 初始化一个控件
        loginButton = (ImageButton) findViewById(R.id.btn);
        acView = (AutoCompleteTextView) findViewById(R.id.acView);
        macView = (MultiAutoCompleteTextView) findViewById(R.id.macTextView);
        tgbtn = (ToggleButton) findViewById(R.id.tbtn);
        // 设置button的监听器，实现点击button要操作的事情
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 在当前onClick方法监听button动作
//                System.out.println("Button clicked");
//            }
//        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, cities);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, cities);

        acView.setAdapter(adapter);
        macView.setAdapter(adapter1);
        macView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        loginButton.setOnClickListener(new MyOnclick() {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this, "hola", Toast.LENGTH_LONG).show();
            }
        });

        tgbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                img = (ImageView)findViewById(R.id.imgv);
                img.setImageResource(isChecked? R.drawable.test: R.drawable.test1);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
