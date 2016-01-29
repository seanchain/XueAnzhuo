package xyz.fxckgfw.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener{
    private ListView listView;
    private ArrayAdapter<String> aadapter;
    private SimpleAdapter sadapter;
    private List<Map<String, Object>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        String [] objects = {"hola", "Ciao", "hello", "Bonjour"};
        aadapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, objects);

        dataList = new ArrayList<Map<String, Object>>();
        sadapter = new SimpleAdapter(this, this.getData(), R.layout.item, new String[] {"pic", "listtext"}, new int[] {R.id.pic, R.id.listtext} );
        /*
        *  context: 上下文
        *  data：数据源 一个Map所组成的list集合
        *  每一个map都回去对应listview列表中的一行
        *  每一个map（键值对）组成，键必须包含所有在from中的指定的键
        *  resource: 列表项的布局文件
        *  from: Map中的键名
        *  to: 绑定数据视图中的ID，和from对应
        *
        * */

        // listView.setAdapter(aadapter);
        listView.setAdapter(sadapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }


    private List<Map<String, Object>> getData() {

        for (int i = 0; i < 20; i ++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", R.drawable.robo);
            map.put("listtext", "Hola" + i);
            dataList.add(map);
        }

        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String valu = listView.getItemAtPosition(position).toString() + "";
        Toast.makeText(MainActivity.this, valu, Toast.LENGTH_LONG).show();
        Log.i("tag", valu);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case SCROLL_STATE_FLING:
                Log.i("SCROLL", "用户在手指离开屏幕之前，由于滑动惯性视图滑动");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("pic", R.drawable.robo);
                map.put("listtext", "增加内容");
                dataList.add(map);
                sadapter.notifyDataSetChanged();

                break;
            case SCROLL_STATE_IDLE:
                Log.i("SCROLL", "视图已经停止滑动");
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                Log.i("SCROLL", "视图正在滑动");
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
