package com.practice.rquan24.foodtruckskeleton;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TruckListAdapter extends RecyclerView.Adapter<TruckListAdapter.TruckViewHolder>
{
    private String[] mTrucks;

    public TruckListAdapter(String[] trucks)
    {
        this.mTrucks = trucks;
    }

    // internal static view holder that the adapter will use
    public static class TruckViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView mImageView;
        private TextView mTextView;
        private ProgressBar mProgressBar;

        // Pick components from passed in view to hold ... heh
        public TruckViewHolder(View view)
        {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.list_item_truck_photo);
            mTextView = (TextView) view.findViewById(R.id.list_item_truck_name);
            mProgressBar = (ProgressBar) view.findViewById(R.id.list_item_progress_bar);
        }
    }

    @Override
    public int getItemCount()
    {
        return mTrucks.length;
    }

    @Override
    public TruckViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // use the parent to inflate the view that each item will use
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.truck_list_item, parent, false);
        TruckViewHolder truckViewHolder = new TruckViewHolder(view);
        return truckViewHolder;
    }

    @Override
    public void onBindViewHolder(TruckViewHolder holder, int position)
    {
        // Pick item from data and set the view to info from the data
        holder.mTextView.setText(mTrucks[position]);
    }

}
