package com.sunrin.task05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://skpla.net/ggqME", new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String getServerData = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(getServerData);

                    String a = jsonObject.getString("a");
                    String b = jsonObject.getString("b");
                    String c = jsonObject.getString("c");
                    textView.setText("a = " + a + ", b =" + b + ", c = " + c);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("sunrin result = ", new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("sunrin result = ", statusCode + "");
            }
        });


    }
}













