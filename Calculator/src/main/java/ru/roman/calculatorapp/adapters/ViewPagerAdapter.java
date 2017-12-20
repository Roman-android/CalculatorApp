package ru.roman.calculatorapp.adapters;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import ru.roman.calculatorapp.R;

/**
 * Created by Roman on 22.07.2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int [] mImageId;

    ImageView imageView;
    private LayoutInflater mLayoutInflater;

    public ViewPagerAdapter(Context context,int [] imgId){
        this.mContext = context;
        this.mImageId = imgId;
    }

    @Override
    public int getCount() {
        //Toast.makeText(mContext, mImageId.length, Toast.LENGTH_SHORT).show();
        return mImageId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        mLayoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mLayoutInflater.inflate(R.layout.fragment_view_pager, container,false);
        imageView = (ImageView)itemView.findViewById(R.id.imgMaterial);

        imageView.setImageResource(mImageId[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
