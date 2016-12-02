package com.sunrin.basic_widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Mission02_1Activity extends Activity {

    private Button mButton;
    private EditText mEditText;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission02_1);

        mButton = (Button) findViewById(R.id.btn_send);
        mEditText = (EditText) findViewById(R.id.edit_text);
        mTextView = (TextView) findViewById(R.id.text_result);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = mEditText.getText().toString();
                Intent intent = new Intent(Mission02_1Activity.this, Mission02_2Activity.class);
                intent.putExtra("phone", phoneNumber);
                startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            boolean result = data.getBooleanExtra("result", false);
            mTextView.setText(result ? "O" : "X");
        }
    }

}
