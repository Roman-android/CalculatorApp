package ru.roman.calculatorapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * Created by Ксения on 18.02.2018.
 */

public class SendProvider extends ActionProvider {

    private Context mContext;

    public SendProvider(Context context){
        super(context);
        this.mContext = context;
    }

    private Intent createShareIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "http://e1.ru");
        Intent choseIntent = Intent.createChooser(shareIntent, "Заголовок");
        //return shareIntent;
        return choseIntent;
    }

    @Override
    public View onCreateActionView() {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.share_layout,null);

        ImageView image = (ImageView) view.findViewById(R.id.share_img);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "123456", Toast.LENGTH_SHORT).show();
                createShareIntent();
            }
        });
        return view;
    }
}
