package com.example.phonedialer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.phonedialer.R;


public class CompassAdapterViewPager extends RecyclerView.Adapter<CompassAdapterViewPager.ViewHolder> {

    Context context;
    ViewPager2 viewPager2;
    private final int [] bg = {R.drawable.bg1,R.drawable.bg2,R.drawable.bg3,R.drawable.bg4,R.drawable.bg5,R.drawable.bg6,R.drawable.bg7,R.drawable.bg8};

    public CompassAdapterViewPager(Context context, ViewPager2 viewPager2) {
        this.context = context;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.item_compass_viewpager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img_view.setImageResource(bg[position]);
//        holder.img_view.setOnClickListener(view -> {
//            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(context, ListCompassDetail.class);
//            intent.putExtra("position",position);
//            context.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return bg.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_view = itemView.findViewById(R.id.img_view);


        }
    }
}
