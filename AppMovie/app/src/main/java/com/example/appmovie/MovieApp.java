package com.example.appmovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MovieApp extends AppCompatActivity {

    private TextInputEditText nameText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie);
        ListView listView = findViewById(R.id.listViewId);
        Button searchButton = findViewById(R.id.searchId);
        nameText = findViewById(R.id.movieInputId);

        List<Movie> movies = new ArrayList<>();

        MovieAdapter movieAdapter = new MovieAdapter(this, movies);
        listView.setAdapter(movieAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // searchMovie();

             //   String searchItem = searchButton.getText().toString();
               // if(!movies.contains(searchItem)){
//                    Intent intent = new Intent(MovieApp.this, Movie.class);
//                    startActivity(intent);


                String API_KEY = "615ed2bc";
                String API_URL = "http://omdbapi.com";
                String Name = nameText.getText().toString();

                RequestParams params = new RequestParams("apikey", API_KEY);
                params.add("s", Name);

                AsyncHttpClient client = new AsyncHttpClient();
                client.get(API_URL, params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            JSONArray items = response.getJSONArray("Search");
                            ArrayList<Movie> movies = new ArrayList<>();

                            for (int i = 0; i < items.length(); i++) {
                                JSONObject singleItem = items.getJSONObject(i);
                                Movie movie = new Movie("", "", 6.5, "");
                                movie.setTitle(singleItem.getString("Title"));
                                movie.setPosterUrl(singleItem.getString("Poster"));

                                movies.add(movie);

                            }

                            movieAdapter.clear();
                            movieAdapter.addAll(movies);
                            movieAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }

                    }
                });
               //     Toast.makeText(MovieApp.this, searchItem + "movie not found", Toast.LENGTH_SHORT).show();
                //}

            }
        });




    }
}
