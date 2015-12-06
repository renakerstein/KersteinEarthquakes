package kerstein.earthquakes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeViewHolder>{

    private Features[]features;

    public EarthquakeRecyclerViewAdapter(Features[]features){
    this.features=features;

    }
    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.earthquake_list_item,parent,false);

        return new EarthquakeViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final EarthquakeViewHolder holder, final int position) {
        holder.bind(features[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, EarthquakeDetail.class);
                intent.putExtra("FEATURES" ,features);
                intent.putExtra("POSITION", position);
                context.startActivity(intent);
            }
        });
    }
        @Override
    public int getItemCount() {
        return features.length;
    }
}
