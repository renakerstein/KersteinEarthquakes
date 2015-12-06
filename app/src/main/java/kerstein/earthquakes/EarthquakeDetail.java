package kerstein.earthquakes;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class EarthquakeDetail extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        Features features[] = (Features[]) getIntent().getSerializableExtra("FEATURES");
        int position = getIntent().getIntExtra("POSITION", 0);
        EarthquakePageAdapter adapter = new EarthquakePageAdapter(features, position);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);

    }


}
