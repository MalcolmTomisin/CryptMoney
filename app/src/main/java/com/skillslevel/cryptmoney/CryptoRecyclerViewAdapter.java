package com.skillslevel.cryptmoney;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CryptoRecyclerViewAdapter extends RecyclerView.Adapter<CryptoRecyclerViewAdapter.ViewHolder> {
    private ArrayList<CryptoCurrency> currencyList;
    private Context context;
    public OnItemClickListener mlistener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mlistener = listener;
    }

    public CryptoRecyclerViewAdapter (ArrayList<CryptoCurrency> cryptList, Context context){
        this.currencyList = cryptList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {
        final CryptoCurrency cryptoCurrency = currencyList.get(position);
        viewHolder.name_txt.setText(cryptoCurrency.get_name());
        Log.d("name", cryptoCurrency.get_name());
        viewHolder.percent_change.setText(cryptoCurrency.get_percent_change_1h());
        viewHolder.price_usd.setText(cryptoCurrency.get_price_usd());

    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name_txt;
        public TextView price_usd;
        public TextView percent_change;
        public ImageView imageView;
//        public LinearLayout linearLayout;

        public ViewHolder(View view){
            super(view);
            name_txt = view.findViewById(R.id.name);
            price_usd = view.findViewById(R.id.price_usd);
            percent_change = view.findViewById(R.id.price_change);
            imageView = view.findViewById(R.id.imageView);
//            linearLayout = view.findViewById(R.id.linearLayout);

            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (mlistener != null){
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION){
                    mlistener.onItemClick(position);
                }
            }
        }
    }
}
