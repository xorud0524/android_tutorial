package com.sunrin.custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 1002230 on 16. 12. 2..
 */
public class CustomViewHolderAdapter extends BaseAdapter {

    private List<User2> users;

    public CustomViewHolderAdapter(List<User2> users) {
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
        User2 user = users.get(i);

        ImageView image;
        TextView textName;
        TextView textPhone;
        TextView textAge;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_view_holder, viewGroup, false);
            image = (ImageView) view.findViewById(R.id.image);
            textName = (TextView) view.findViewById(R.id.text_name);
            textPhone = (TextView) view.findViewById(R.id.text_phone);
            textAge = (TextView) view.findViewById(R.id.text_age);
        } else {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            image = viewHolder.image;
            textName = viewHolder.textName;
            textPhone = viewHolder.textPhone;
            textAge = viewHolder.textAge;
        }

        if (user.getImage() == 0) {
            image.setImageResource(android.R.drawable.ic_media_ff);
        } else {
            image.setImageResource(android.R.drawable.ic_media_rew);
        }
        textName.setText(user.getName());
        textPhone.setText(user.getPhone());
        textAge.setText(String.valueOf(user.getAge()));

        return view;
    }

    private static class ViewHolder {

        public final ImageView image;
        public final TextView textName;
        public final TextView textPhone;
        public final TextView textAge;

        public ViewHolder(ImageView image, TextView textName, TextView textPhone, TextView textAge) {
            this.image = image;
            this.textName = textName;
            this.textPhone = textPhone;
            this.textAge = textAge;
        }
    }

}
