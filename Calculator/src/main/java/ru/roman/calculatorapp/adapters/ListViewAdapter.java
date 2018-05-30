package ru.roman.calculatorapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.roman.calculatorapp.R;

/**
 * Created by Roman on 15.04.2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<String> getNumberArray;
    private String[] getItemArray;

    private LayoutInflater mLayoutInflater;

    public ListViewAdapter(Context context, ArrayList<String> numberArray, String[] itemArray) {
        mLayoutInflater = LayoutInflater.from(context);
        this.getNumberArray = numberArray;
        this.getItemArray = itemArray;
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

        TextView numberView = convertView.findViewById(R.id.text_item);
        numberView.setText(getNumberArray.get(position));

        TextView textView = convertView.findViewById(R.id.textItem);
        textView.setText(getItemArray[position]);

        return convertView;
    }

    public String getString (int position){
        return getItemArray[position];
    }
}
