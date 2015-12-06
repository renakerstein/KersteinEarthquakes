package kerstein.earthquakes;

import java.io.Serializable;

public class Properties implements Serializable{

    private String place;
    private long time;
    private double mag;

    public String getPlace() {
        return place;
    }

    public long getTime() {
        return time;
    }

    public double getMag() {
        return mag;
    }
}
