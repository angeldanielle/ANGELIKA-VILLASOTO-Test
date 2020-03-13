package com.stratpoint.android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.MyViewHolder>{

    private List<Player> playerList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView player_name;
        public TextView score;

        public MyViewHolder(View view) {
            super(view);
            player_name = (TextView) view.findViewById(R.id.player_name);
            score = (TextView) view.findViewById(R.id.score);
        }
    }

    public PlayersAdapter(List<Player> playerList){this.playerList = playerList;}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View dataView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(dataView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Player player = playerList.get(position);
        holder.player_name.setText("Player Name: " + player.getPlayer_name());
        holder.score.setText("Score: " + player.getScore());
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

}
