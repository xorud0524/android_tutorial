package com.sunrin.basic_widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mission01Activity extends Activity {

    private TextView mTextView;
    private Button mButton;
    private EditText mEditText;

    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission01);

        //xml에서 선언한 id와 연동 (초기화)
        mTextView = (TextView)findViewById(R.id.text_view);
        mButton = (Button)findViewById(R.id.button);
        mEditText = (EditText)findViewById(R.id.edit_text);


        //클릭리스너 선언
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText(mEditText.getText().toString());
            }
        };

        //클릭리스너 등록
        mButton.setOnClickListener(onClickListener);

    }
}
