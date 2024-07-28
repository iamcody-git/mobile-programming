package com.example.appmovie;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieApp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie);

        ListView listView = findViewById(R.id.listViewId);

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Mubbin","description" ,8.8, ""));
        movies.add(new Movie("Shaun the ship","description" ,6.8, ""));

        MovieAdapter movieAdapter = new MovieAdapter(this, movies);
        listView.setAdapter(movieAdapter);





    }
}
