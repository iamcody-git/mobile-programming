package com.example.moviesearch;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

public class MovieActivity extends AppCompatActivity {
    private TextInputEditText nameText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        ListView listView = findViewById(R.id.ListViewId);
        Button searchButton = findViewById(R.id.submitButton);
        nameText = findViewById(R.id.movieInputEditText);


        //  String[] movies = {"pulp fiction", "before sunrise", "hulk"};

        List<Movie> movies = new ArrayList<Movie>();

//        movies.add(new Movie("pulp fiction", "Description", 5.8, ""));
//        movies.add(new Movie("shaun the ship", "Description", 7.8, ""));
//        movies.add(new Movie("Mubbin", "Description", 9.8, ""));


        MovieAdapter movieAdapter = new MovieAdapter(this, movies);

        listView.setAdapter(movieAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_KEY = "615ed2bc";
                String API_URL = "http://omdbapi.com/";
                String Name = nameText.getText().toString();

                RequestParams params = new RequestParams("apikey", API_KEY);
                params.add("s", Name);

                AsyncHttpClient client = new AsyncHttpClient();
                client.get(API_URL, params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                       Log.d("api", "Status Code :" + statusCode + " response : " + response.toString());

                        try {
                            JSONArray items = response.getJSONArray("Search");
                            ArrayList<Movie> movies = new ArrayList<Movie>();

                            for (int i = 0; i < items.length(); i++) {
                                JSONObject singleItem = items.getJSONObject(i);
                                Movie movie = new Movie();
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

            }
        });

    }
}

