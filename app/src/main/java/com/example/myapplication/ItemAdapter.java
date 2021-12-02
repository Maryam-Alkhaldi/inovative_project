package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] recipes;
    String[] times;
    String[] prices;

    public ItemAdapter(Context c, String[] r, String[] p, String[] t){
        recipes = r;
        prices = p;
        times = t;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return recipes.length;
    }

    @Override
    public Object getItem(int position) {
        return recipes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.recipe_list_layout, null);
        TextView nameTextView = (TextView) view.findViewById(R.id.recipeName);
        TextView timeView = (TextView) view.findViewById(R.id.timeView);
        TextView priceView = (TextView) view.findViewById(R.id.priceView);

        String name = recipes[position];
        String time = times[position];
        String price = prices[position];

        nameTextView.setText(name);
        timeView.setText(time);
        priceView.setText(price);

        return view;
    }
}
