package com.sunrin.custom_listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mButtonListView, mButtonGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonListView = (Button) findViewById(R.id.btn_list_view);
        mButtonGridView = (Button) findViewById(R.id.btn_grid_view);

        mButtonListView.setOnClickListener(this);
        mButtonGridView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_list_view:
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                break;

            case R.id.btn_grid_view:
                startActivity(new Intent(MainActivity.this, GridViewActivity.class));
                break;

        }
    }
}
