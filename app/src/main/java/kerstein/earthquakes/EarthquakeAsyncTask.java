package kerstein.earthquakes;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EarthquakeAsyncTask extends AsyncTask<String, Void, Earthquake > {

    private RecyclerView recyclerView;
    private Earthquake earthquake;

    public EarthquakeAsyncTask(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.earthquake = null;
    }

    @Override
    protected Earthquake doInBackground(String... params) {
        try {
            URL url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // read it in
            InputStream in = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            Gson gson = new Gson();
            earthquake = gson.fromJson(br, Earthquake.class);
            br.close();
        } catch (IOException e) {

        }

        return earthquake;
    }

    @Override
    protected void onPostExecute(Earthquake result) {
        super.onPostExecute(result);
        Features[] features = result.getFeatures();
        EarthquakeRecyclerViewAdapter adapter = new EarthquakeRecyclerViewAdapter(features);
        recyclerView.setAdapter(adapter);
    }
}