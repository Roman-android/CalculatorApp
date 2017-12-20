package ru.roman.calculatorapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import ru.roman.calculatorapp.R;

/**
 * Created by Roman on 15.04.2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private String[] getItemArray;
    private Integer[] getImageArray;

    private LayoutInflater mLayoutInflater;

    public ListViewAdapter(Context context, String[] itemArray, Integer[] imageArray) {
        mLayoutInflater = LayoutInflater.from(context);
        this.getItemArray = itemArray;
        this.getImageArray = imageArray;
    }

    @Override
    public int getCount() {
        return getItemArray.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.list_item,null);
        }

        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageItem);
        imageView.setImageResource(getImageArray[position]);

        TextView textView = (TextView)convertView.findViewById(R.id.textItem);
        textView.setText(getItemArray[position]);

        return convertView;
    }

    public String getString (int position){
        return getItemArray[position];
    }
}
