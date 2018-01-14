package ru.roman.calculatorapp.adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ru.roman.calculatorapp.R;

/**
 * Created by Roman on 22.07.2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int [] mImageId;
    private String [] mDescText;

    private LayoutInflater mLayoutInflater;
    private ImageView imageView;
    private TextView descText;

    public ViewPagerAdapter(Context context,int [] imgId,String [] description){
        this.mContext = context;
        this.mImageId = imgId;
        this.mDescText = description;
    }

    @Override
    public int getCount() {
        return mImageId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        mLayoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = null;
        if (mLayoutInflater != null) {
            itemView = mLayoutInflater.inflate(R.layout.fragment_view_pager, container,false);
        }
        if (itemView != null) {
            imageView = itemView.findViewById(R.id.imgMaterial);
        }
        if (itemView != null) {
            descText = itemView.findViewById(R.id.description);
        }

        imageView.setImageResource(mImageId[position]);
        descText.setText(mDescText[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
