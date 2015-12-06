package kerstein.earthquakes;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class EarthquakePageAdapter extends  PagerAdapter{

        private Features[] features;
        private int position;

    public EarthquakePageAdapter(Features[]features, int position){
        this.features=features;
        this.position=position;

    }

    @Override
    public int getCount() {
        return features.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater=LayoutInflater.from(container.getContext());
        View view= inflater.inflate(R.layout.earthquake_pager_item, null);

        TextView place= (TextView)view.findViewById(R.id.place);
        TextView time= (TextView)view.findViewById(R.id.time);
        TextView mag= (TextView)view.findViewById(R.id.mag);

       Properties property= features[position].getProperty();

        SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String newDate= formatter.format(property.getTime());

        place.setText("PLACE: ");
        place.append(property.getPlace());
        time.setText("TIME: ");
        time.append((newDate));
        mag.setText("MAGNITUDE: ");
        mag.append(String.valueOf(property.getMag()));

        container.addView(view);
        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }


}
