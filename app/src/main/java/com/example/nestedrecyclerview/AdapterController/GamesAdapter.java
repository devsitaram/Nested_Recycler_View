package com.example.nestedrecyclerview.AdapterController;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.PojoModel.GamesModelClass;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;
import java.util.Random;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {

    Context context;
    ArrayList<GamesModelClass> gamesModelClassesArrayList;

    public GamesAdapter(Context context, ArrayList<GamesModelClass> gamesModelClassesArrayList) {
        this.context = context;
        this.gamesModelClassesArrayList = gamesModelClassesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.games_items, null, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GamesModelClass gamesModelClass = gamesModelClassesArrayList.get(position);
        holder.tvAlphabet.setText(gamesModelClass.getProfileLetter().toString());
        holder.tvAlphabet.setBackgroundColor(GamesModelClass.getColor());

        holder.tvName.setText(gamesModelClassesArrayList.get(position).name);
        holder.tvNumber.setText(gamesModelClassesArrayList.get(position).number);
    }

    @Override
    public int getItemCount() {
        return gamesModelClassesArrayList.size();
    }

    // sub classes
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAlphabet, tvName, tvNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlphabet = itemView.findViewById(R.id.iv_games_item);
            tvName = itemView.findViewById(R.id.tvName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
        }
    }
}
