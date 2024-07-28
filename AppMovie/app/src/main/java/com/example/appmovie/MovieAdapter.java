package com.example.appmovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private List<Movie> movies;
    public MovieAdapter(Context context, List<Movie> movies){
        super(context,0,movies);
        this.movies=movies;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       if(convertView == null){
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_list, parent,false);

       }

       Movie currentMovie = movies.get(position);

        ImageView posterView = convertView.findViewById(R.id.imageId);
        TextView titleView = convertView.findViewById(R.id.titleId);
        TextView ratingView = convertView.findViewById(R.id.rateId);
        TextView descView = convertView.findViewById(R.id.descId);

        titleView.setText(currentMovie.getTitle());
        ratingView.setText(String.format("%s",currentMovie.getRating()));
        descView.setText(currentMovie.getDescription());

        return convertView;



    }
}
