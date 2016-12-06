package com.sunrin.custom_listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewViewHolderActivity extends Activity {

    private ListView listView;
    private CustomViewHolderAdapter customViewHolderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_view_holder);

        final List<User2> users = new ArrayList<>();
        users.add(new User2(0, "라이언", "010-1234-1234", 10));
        users.add(new User2(0, "모찌", "110-1234-1234", 34));
        users.add(new User2(0, "무지", "210-1234-1234", 13));
        users.add(new User2(0, "뽀로로", "310-1234-1234", 16));
        users.add(new User2(1, "셀리", "410-1234-1234", 35));
        users.add(new User2(1, "브라운", "510-1234-1234", 15));
        users.add(new User2(1, "코니", "610-1234-1234", 13));
        users.add(new User2(1, "프로도", "710-1234-1234", 41));
        users.add(new User2(1, "러버덕", "810-1234-1234", 20));


        listView = (ListView) findViewById(R.id.list_view_view_holder);
        customViewHolderAdapter = new CustomViewHolderAdapter(users);
        listView.setAdapter(customViewHolderAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(ListViewViewHolderActivity.this, users.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(ListViewViewHolderActivity.this, String.valueOf(users.get(position).getAge()), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
