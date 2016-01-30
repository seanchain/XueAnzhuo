package xyz.fxckgfw.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter simpleAdapter;
    private String[] iconName = {"1", "2", "3", "4", "5", "6"};
    private int[] icon = {R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = new ArrayList<Map<String, Object>>();
        gridView = (GridView) findViewById(R.id.gridView);
        simpleAdapter = new SimpleAdapter(MainActivity.this, getData(), R.layout.item,
                new String[] {"img", "txt"}, new int[] {R.id.img, R.id.txt});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("pos", "" + position + "-" + iconName[position]);
                Toast.makeText(MainActivity.this, "Hola", Toast.LENGTH_LONG).show();
            }
        });
    }


    private List<Map<String, Object>> getData() {
        for (int i = 0; i < icon.length; i ++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", icon[i]);
            map.put("txt", iconName[i]);
            dataList.add(map);
        }
        return dataList;
    }
}
