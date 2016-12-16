package com.sunrin.database_realm;

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
public class CustomAdapter extends BaseAdapter {

    private List<Pet> pets;

    public CustomAdapter(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public int getCount() {
        return pets.size();
    }

    @Override
    public Object getItem(int i) {
        return pets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Context context = viewGroup.getContext();
        Pet pet = pets.get(i);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }

        TextView textType = ViewHolder.get(view, R.id.text_type);
        TextView textName = ViewHolder.get(view, R.id.text_name);
        TextView textAge = ViewHolder.get(view, R.id.text_age);

        textType.setText("종류 : " + pet.getType());
        textName.setText("이름 : " + pet.getName());
        textAge.setText("나이 : " + pet.getAge());

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
