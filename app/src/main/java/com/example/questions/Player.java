package com.example.questions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private List<Player> playerList = new ArrayList<>();

    private RadioGroup rgr;
    private EditText textE;
    private ImageView del;

    public class PlayerViewHolder extends  RecyclerView.ViewHolder{

        public PlayerViewHolder(View itemView) {
            super(itemView);
            rgr = itemView.findViewById(R.id.radio_group);
            textE = itemView.findViewById(R.id.textname);
            del = itemView.findViewById(R.id.delete_click);
        }
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
