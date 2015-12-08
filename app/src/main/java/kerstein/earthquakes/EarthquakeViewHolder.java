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
        for(int i=0; i<array.length; i++){
            if(array[i].equalsIgnoreCase("of")){
               int count=i+1;
                for(int j=count; j<array.length; j++){
                    builder.append(array[j]);
                    builder.append(" ");
                }
            }

            }
        name.setText(builder.toString());
    }
}
