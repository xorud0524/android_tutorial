package com.sunrin.basic_widget;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button mButtonMission01, mButtonMission02, mButtonMission03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonMission01 = (Button) findViewById(R.id.btn_mission01);
        mButtonMission02 = (Button) findViewById(R.id.btn_mission02);
        mButtonMission03 = (Button) findViewById(R.id.btn_mission03);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_mission01:
                        startActivity(new Intent(MainActivity.this, Mission01Activity.class));
                        break;
                    case R.id.btn_mission02:
                        startActivity(new Intent(MainActivity.this, Mission02_1Activity.class));
                        break;
                    case R.id.btn_mission03:
                        startActivity(new Intent(MainActivity.this, Mission03Activity.class));
                        break;
                }
            }
        };
        mButtonMission01.setOnClickListener(onClickListener);
        mButtonMission02.setOnClickListener(onClickListener);
        mButtonMission03.setOnClickListener(onClickListener);
    }
}
