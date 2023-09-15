package com.example.phonedialer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonedialer.ListCompassDetail;
import com.example.phonedialer.R;


public class CompassAdapter extends RecyclerView.Adapter<CompassAdapter.ViewHolder> {

    Context context;
    private final int [] bg = {R.drawable.ic_stand,R.drawable.ic_digital_compass,R.drawable.ic_camera_compass,R.drawable.ic_qibla_compass,R.drawable.ic_satellite_compass,R.drawable.ic_map_compasss,R.drawable.ic_aviation_compass,R.drawable.ic_vintage_compass};

    public CompassAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.item_compass, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img_view.setImageResource(bg[position]);
        holder.img_view.setOnClickListener(view -> {
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, ListCompassDetail.class);
            intent.putExtra("position",position);
            context.startActivity(intent);
        });
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
