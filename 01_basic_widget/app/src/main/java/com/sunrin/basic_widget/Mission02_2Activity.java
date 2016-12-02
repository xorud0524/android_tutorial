package com.sunrin.basic_widget;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Mission02_2Activity extends Activity {

    private TextView mTextExtraPhone;
    private TextView mTextInfoPhone;
    private TextView mTextResult;

    private Intent getIntent;
    private String getExtraPhoneNumber;
    private String getInfoPhoneNumber;
    private boolean isNumberSame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission02_2);

        getIntent = getIntent();
        getExtraPhoneNumber = getIntent.getStringExtra("phone");
        getInfoPhoneNumber = ((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getLine1Number();

        isNumberSame = getExtraPhoneNumber.equals(getInfoPhoneNumber);

        mTextExtraPhone = (TextView) findViewById(R.id.text_extra_phone);
        mTextInfoPhone = (TextView) findViewById(R.id.text_info_phone);
        mTextResult = (TextView) findViewById(R.id.text_result);

        int textColor = isNumberSame ? Color.BLUE : Color.RED;
        mTextResult.setTextColor(textColor);

        mTextExtraPhone.setText(getExtraPhoneNumber);
        mTextInfoPhone.setText(getInfoPhoneNumber);
        mTextResult.setText(isNumberSame ? "O" : "X");

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("result", isNumberSame);
        setResult(200, intent);
        finish();
    }
}
