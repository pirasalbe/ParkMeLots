package nullpointerexception.signtheway;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 26/11/2016.
 */
public class Signal {
    private int key, codSignal;
    private double lat, lon;
    private Map<Integer, String> urlMap;

    public Signal(int key, int codSignal, double lat, double lon){
        this.key = key;
        this.codSignal = codSignal;
        this.lat = lat;
        this.lon = lon;
    }

    public static List<Signal> getSignalsFromString(String signals){
        List<Signal> signalList = new ArrayList<Signal>();
        String[] signalsArray = signals.split(";");
        for (String singleSignal: signalsArray) {
            String[] signalProperties = singleSignal.split(":");
            Signal signal = new Signal(Integer.parseInt(signalProperties[0]), Integer.parseInt(signalProperties[1]),
                    Double.parseDouble(signalProperties[2]), Double.parseDouble(signalProperties[3]));
            signalList.add(signal);
        }
        return signalList;
    }

    private void initUrlMap()
    {
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");
        this.urlMap.put(, "");

    }
}
