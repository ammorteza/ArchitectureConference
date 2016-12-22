package com.ammorteza.architectureconference;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Am on 07/13/2015.
 */
public class LoadBigImage {
    private static int parentWidth;

    public static void createResizedImageView(Context context, final ImageView imageView,final int pw , final String imagePath)
    {
        parentWidth = pw;
        //AssetManager assetMgr = context.getAssets();
        //Bitmap myPic = null;
        //final BitmapFactory.Options o=LoadBigImage.getImageSize(context,imagePath);
        //Log.d("mmmmmmmmmmmmmmmmmmmmmmmmmm", o.outWidth + "");
        //Glide.with(context).load("file:///android_asset/" + imagePath).override(parentWidth, (int) ((o.outHeight * parentWidth) / o.outWidth)).into(imageView);
        Glide.with(context)
                .load(imagePath)
                //.placeholder(R.anim.loader)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void createResizedImageViewWithoutPlaceHolder(Context context, final ImageView imageView,final int pw , final String imagePath)
    {
        parentWidth = pw;
        //AssetManager assetMgr = context.getAssets();
        //Bitmap myPic = null;
        //final BitmapFactory.Options o=LoadBigImage.getImageSize(context,imagePath);
        //Log.d("mmmmmmmmmmmmmmmmmmmmmmmmmm", o.outWidth + "");
        //Glide.with(context).load("file:///android_asset/" + imagePath).override(parentWidth, (int) ((o.outHeight * parentWidth) / o.outWidth)).into(imageView);
        Glide.with(context)
                .load(imagePath)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void createResizedImageViewWithoutPlaceHolderFromAssets(Context context, final ImageView imageView, final String imagePath)
    {
        //parentWidth = pw;
        //AssetManager assetMgr = context.getAssets();
        //Bitmap myPic = null;
        //final BitmapFactory.Options o=LoadBigImage.getImageSize(context,imagePath);
        //Log.d("mmmmmmmmmmmmmmmmmmmmmmmmmm", o.outWidth + "");
        //Glide.with(context).load("file:///android_asset/img/" + imagePath).override(parentWidth, (int) ((o.outHeight * parentWidth) / o.outWidth)).into(imageView);
/*        Glide.with(context)
                .load(imagePath)
                .into(imageView);*/
        Glide.with(context)
                .load("file:///android_asset/img/" + imagePath)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
