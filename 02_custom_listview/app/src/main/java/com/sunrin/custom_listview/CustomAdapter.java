package com.sunrin.custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 1002230 on 16. 12. 2..
 */
public class CustomAdapter extends BaseAdapter {

    private List<User> users;

    public CustomAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Context context = viewGroup.getContext();
        User user = users.get(i);

        view = LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false);

        TextView textName = (TextView) view.findViewById(R.id.text_name);
        TextView textPhone = (TextView) view.findViewById(R.id.text_phone);
        TextView textAge = (TextView) view.findViewById(R.id.text_age);


        textName.setText(user.getName());
        textPhone.setText(user.getPhone());
        textAge.setText(String.valueOf(user.getAge()));

        return view;
    }
}
