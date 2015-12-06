package kerstein.earthquakes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class EarthquakeViewHolder extends RecyclerView.ViewHolder {

    private TextView name;

    public EarthquakeViewHolder(View itemView){
        super(itemView);
        name=(TextView) itemView.findViewById(R.id.name);
    }

    //set the data in the text view
    public void bind(Features feature){
        String place=feature.getProperty().getPlace();
        String[]array=place.split(" ");
        StringBuilder builder= new StringBuilder();
        for(int i=3; i<array.length; i++){
                builder.append(array[i]);
                builder.append(" ");
            }
        name.setText(builder.toString());
    }
}
