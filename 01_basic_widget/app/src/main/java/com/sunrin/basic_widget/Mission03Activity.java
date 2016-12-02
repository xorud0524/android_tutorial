package com.sunrin.basic_widget;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mission03Activity extends Activity {

    private Button mButtonCount;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission03);

        mButtonCount = (Button) findViewById(R.id.btn_cnt);


        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        count = pref.getInt("count", 0);
        mButtonCount.setText(count + " 번 클릭");

        mButtonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                ((Button) view).setText(count + " 번 클릭");
                editor.putInt("count", count);
                editor.apply();
            }
        });
    }
}
