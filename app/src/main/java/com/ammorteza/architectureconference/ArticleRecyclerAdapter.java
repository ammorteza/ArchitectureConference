package com.ammorteza.architectureconference;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ammorteza on 2/5/16.
 */
public class ArticleRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<HashMap<String , Object>> mItemList;
    private Context context;

    public ArticleRecyclerAdapter(Context c, ArrayList<HashMap<String, Object>> itemList) {
        mItemList = itemList;
        context = c;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout, parent, false);
        return ArticleRecyclerItemViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ArticleRecyclerItemViewHolder holder = (ArticleRecyclerItemViewHolder) viewHolder;
        holder.setSubject(mItemList.get(position).get("subject").toString());
        holder.setOwner(mItemList.get(position).get("owner").toString());
        holder.setCardViewListener();
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

}
