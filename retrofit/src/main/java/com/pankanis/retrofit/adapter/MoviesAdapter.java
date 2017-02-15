package com.pankanis.retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pankanis.retrofit.R;
import com.pankanis.retrofit.model.MovieModel;

import java.util.List;

/**
 * Created by sumit.ingewar on 2/15/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {


    private List<MovieModel> list;
    private int rowLayout;
    private Context context;

    public MoviesAdapter(List<MovieModel> list, int rowLayout, Context context) {
        this.list = list;
        this.rowLayout = rowLayout;
        this.context = context;
    }

      static class MovieViewHolder extends RecyclerView.ViewHolder {

        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;

        MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);

        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.movieTitle.setText(list.get(position).getTitle());
        holder.data.setText(list.get(position).getReleaseDate());
        holder.movieDescription.setText(list.get(position).getOverview());
        holder.rating.setText(list.get(position).getVoteAverage().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
