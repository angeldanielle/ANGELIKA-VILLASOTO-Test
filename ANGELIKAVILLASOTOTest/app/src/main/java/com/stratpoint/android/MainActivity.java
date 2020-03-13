package com.stratpoint.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import org.json.*;

import com.stratpoint.android.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Player> playerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PlayersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mAdapter = new PlayersAdapter(playerList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    private void prepareData() {
        URL mockyUrl = NetworkUtils.buildUrl();
        new MockyQueryTask().execute(mockyUrl);
    }

    public class MockyQueryTask extends AsyncTask<URL, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String mockyResults = null;
            try {
                mockyResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return mockyResults;
        }

        @Override
        protected void onPostExecute(String mockyResults){

            if (mockyResults != null && !mockyResults.equals("")) {
                try {
                    //parses JSON
                    JSONObject obj = new JSONObject(mockyResults);
                    JSONArray sys = obj.getJSONArray("data");
                    for(int count = 0; count < sys.length(); count++) {
                        JSONObject objPlayer = sys.getJSONObject(count);
                        String player_name = objPlayer.getString("player_name");
                        String score = objPlayer.getString("score");

                        Player player = new Player(player_name, score);
                        playerList.add(player);
                        mAdapter.notifyDataSetChanged();
                    }

                } catch (Throwable t) {
                    Log.e("Mocky", "error" + t.toString());
                }
            }

        }
    }


}
