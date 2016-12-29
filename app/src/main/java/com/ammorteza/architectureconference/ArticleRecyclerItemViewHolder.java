package com.ammorteza.architectureconference;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ammorteza on 2/5/16.
 */
public class ArticleRecyclerItemViewHolder extends RecyclerView.ViewHolder{
    private final TextView subject;
    private final TextView owner;
    private final CardView cardView;

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

    public void setSubject(CharSequence text) {
        subject.setText(text);
    }
    public void setOwner(CharSequence text) {
        owner.setText(text);
    }

    public void setCardViewListener()
    {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof CardView) {
                    // use getAdapterPosition() instead of getLayoutPosition()
                    int itemPosition = getAdapterPosition();
                    Log.d("ddddddddddddddddddd" , "ddddddddddddddddddddddddddddd" + itemPosition);
                }
            }
        });
    }

}
