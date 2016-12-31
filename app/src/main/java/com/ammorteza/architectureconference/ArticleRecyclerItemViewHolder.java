package com.ammorteza.architectureconference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by ammorteza on 2/5/16.
 */
public class ArticleRecyclerItemViewHolder extends RecyclerView.ViewHolder{
    private final TextView subject;
    private final TextView owner;
    private final CardView cardView;
    private Activity activity;
    private HashMap<String , Object> itemValue;

    public ArticleRecyclerItemViewHolder(final View parent, CardView cView ,TextView sub , TextView own) {
        super(parent);
        cardView = cView;
        subject = sub;
        owner = own;

    }

    public static ArticleRecyclerItemViewHolder newInstance(View parent) {
        TextView subject = (TextView) parent.findViewById(R.id.subject);
        TextView owner = (TextView) parent.findViewById(R.id.owner);
        CardView cardView = (CardView) parent.findViewById(R.id.articleCardView);
        return new ArticleRecyclerItemViewHolder(parent , cardView , subject , owner);
    }

    public void init(Activity act , HashMap<String , Object> value)
    {
        activity = act;
        itemValue = value;
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof CardView) {
                    // use getAdapterPosition() instead of getLayoutPosition()
                    int itemPosition = getAdapterPosition();
                    Log.d("ddddddddddddddddddd", "ddddddddddddddddddddddddddddd" + itemPosition);
                    Intent articleInfo = new Intent(activity, ArticleActivity.class);
                    articleInfo.putExtra("itemValue" , itemValue);
                    activity.startActivity(articleInfo);
                    activity.overridePendingTransition(R.anim.page_pull_in_right, R.anim.page_push_out_left);
                }
            }
        });

        subject.setText(itemValue.get("subject").toString());
        owner.setText(itemValue.get("owner").toString());
    }

}
