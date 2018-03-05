package com.nagizade.musicapp;

/**
 * Created by Nagizade on 3/2/2018.
 */
import java.util.ArrayList;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {

    private ArrayList<Song> songs;
    private LayoutInflater mInflater;
    private ItemClickListener clickListener;

    // data is passed into the constructor
    SongListAdapter(Context context, ArrayList<Song> songList) {
        this.mInflater = LayoutInflater.from(context);
        this.songs = songList;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.song, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //get song using position
        Song currSong = songs.get(position);

        //get title and artist strings
        holder.songView.setText(currSong.getTitle());
        holder.artistView.setText(currSong.getArtist());

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return songs.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView songView;
        TextView artistView;
        ViewHolder(View itemView) {
            super(itemView);
            songView = (TextView) itemView.findViewById(R.id.song_title);
            artistView = (TextView) itemView.findViewById(R.id.song_artist);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition()); // call the onClick in the OnItemClickListener
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return null;
    }
}