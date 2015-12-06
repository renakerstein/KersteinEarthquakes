package kerstein.earthquakes;

import java.io.Serializable;

public class Earthquake  implements Serializable{
    private Features[]features;

    public Features[] getFeatures() {
        return features;
    }
}
