package com.ammorteza.architectureconference;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ammorteza on 12/11/16.
 */
public class AssetsImageView extends ImageView {
    private String ASSTES_SRC = "";
    private boolean RESIZEABLE = true;
    public AssetsImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.AssetsImageView);
        ASSTES_SRC = a.getString(R.styleable.AssetsImageView_assets_src);
        RESIZEABLE = a.getBoolean(R.styleable.AssetsImageView_resizeable , true);
        a.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        try
        {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            AssetManager assetManager = getContext().getAssets();

            InputStream istr = assetManager.open(ASSTES_SRC);
            Bitmap bitmap = BitmapFactory.decodeStream(istr,null,options);
            setImageBitmap(bitmap);
/*            InputStream ims = getContext().getAssets().open(ASSTES_SRC);
            Drawable d = Drawable.createFromStream(ims, null);
            setImageDrawable(d);
            ims .close();*/
        }
        catch(IOException ex)
        {
            return;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        Drawable d = getDrawable();

        if(d!=null && RESIZEABLE){
            // ceil not round - avoid thin vertical gaps along the left/right edges
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = (int) Math.ceil((float) width * (float) d.getIntrinsicHeight() / (float) d.getIntrinsicWidth());
            setMeasuredDimension(width, height);
        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
