package com.sunrin.custom_listview;

import android.content.Context;
import android.util.SparseArray;
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
public class CustomViewHolderAdapter2 extends BaseAdapter {

    private List<User2> users;

    public CustomViewHolderAdapter2(List<User2> users) {
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

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_view_holder, viewGroup, false);
        }
        ImageView image = ViewHolder.get(view, R.id.image);
        TextView textName = ViewHolder.get(view, R.id.text_name);
        TextView textPhone = ViewHolder.get(view, R.id.text_phone);
        TextView textAge = ViewHolder.get(view, R.id.text_age);

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
        public static <T extends View> T get(View view, int id) {
            SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
            if (viewHolder == null) {
                viewHolder = new SparseArray<View>();
                view.setTag(viewHolder);
            }
            View childView = viewHolder.get(id);
            if (childView == null) {
                childView = view.findViewById(id);
                viewHolder.put(id, childView);
            }
            return (T) childView;
        }
    }

}
