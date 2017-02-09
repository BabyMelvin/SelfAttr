package com.chuangjia.selfattr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Melvin on 2017/2/9.
 */

public class IconText extends LinearLayout{
    private static final String TAG = "IconText";
    private final int ICON_LEFT=0;
    private final int ICON_RIGHT=1;
    private final int ICON_ABOVE=2;
    private final int ICON_BELOW=3;
    private int mRelation=ICON_LEFT;
    private String mText;
    private float mTextSize;
    private int mSpace;
    private int mIconId;
    private TextView mTextVIew;
    private ImageView mImageView;

    public IconText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.IconText);
        mRelation = a.getInt(R.styleable.IconText_relation,ICON_LEFT);
        Log.d(TAG, "IconText: mRelation"+mRelation);
        mText = a.getString(R.styleable.IconText_text);
        Log.d(TAG, "IconText: mText"+mText);
        mTextSize = a.getDimensionPixelSize(R.styleable.IconText_text_size,12);
        Log.d(TAG, "IconText: mTextSize"+mTextSize);
        mSpace = a.getDimensionPixelSize(R.styleable.IconText_space,5);
        Log.d(TAG, "IconText: mSpace"+mSpace);
        mIconId = a.getResourceId(R.styleable.IconText_icon,R.mipmap.ic_launcher);
        Log.d(TAG, "IconText: mIconId"+ mIconId);
        a.recycle();
        mTextVIew = new TextView(context);
        mTextVIew.setText(mText);
        mTextVIew.setTextSize(mTextSize);
        mImageView = new ImageView(context);
        mImageView.setImageResource(mIconId);
        int left=0;
        int top=0;
        int bottom=0;
        int right=0;
        int orientation=HORIZONTAL;
        int textViewIndex=0;
        switch (mRelation){
            case ICON_ABOVE:
                orientation=VERTICAL;
                bottom=mSpace;
                textViewIndex=1;
                break;
            case ICON_BELOW:
                orientation=VERTICAL;
                top=mSpace;
                break;
            case ICON_LEFT:
                right=mSpace;
                textViewIndex=1;
                break;
            case ICON_RIGHT:
                left=mSpace;
                break;

        }
        this.setOrientation(orientation);
        this.addView(mImageView);
        mImageView.setPadding(left,top,right,bottom);
        this.addView(mTextVIew,textViewIndex);
    }
}
