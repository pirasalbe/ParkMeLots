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
    private static Map<Integer, String> urlMap;

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
        this.urlMap.put(1, "http://www.santaluciacava.it/images/segn_str_dosso.JPG");
        this.urlMap.put(2, "http://www.santaluciacava.it/images/segn_str_dosso%201.JPG");
        this.urlMap.put(3, "http://www.santaluciacava.it/images/segn_str_cunetta.JPG");
        this.urlMap.put(5, "http://www.santaluciacava.it/images/segn_str_CURVA%20PERICOLOSA%20SINISTRA.JPG");
        this.urlMap.put(7, "http://www.santaluciacava.it/images/segn_str_curva%20pericolosa.JPG");
        this.urlMap.put(8, "http://www.santaluciacava.it/images/segn_str_passaggio%20a%20livello.JPG");
        this.urlMap.put(9, "http://www.santaluciacava.it/images/segn_str_passaggio%20livello%20incustodito.JPG");
        this.urlMap.put(10, "http://www.santaluciacava.it/images/segn_str_CROCE%20DI%20S.ANDREA.JPG");
        this.urlMap.put(11, "http://www.santaluciacava.it/images/segn_str_DOPPIA%20CROCE%20S.ANDREA.JPG");
        this.urlMap.put(15, "http://www.santaluciacava.it/images/segn_str_ATTRAVERSAMENTO%20PEDONALE.JPG");

        this.urlMap.put(17, "http://www.santaluciacava.it/images/segn_str_discesa%20pericolosa.JPG");
        this.urlMap.put(18, "http://www.santaluciacava.it/images/segn_str_salita%20ripida.JPG");
        this.urlMap.put(19, "http://www.santaluciacava.it/images/segn_str_RESTRINGIMENTO%20STRADA.JPG");
        this.urlMap.put(21, "http://www.santaluciacava.it/images/segn_str_RISTRINGIMENTO%20STRADA%20DESTRA.JPG");
        this.urlMap.put(23, "http://www.santaluciacava.it/images/segn_str_banchina%20pericolosa.JPG");
        this.urlMap.put(24, "http://www.santaluciacava.it/images/segn_str_STRADA%20SDRUCCIOLEVOLE.JPG");
        this.urlMap.put(25, "http://www.santaluciacava.it/images/segn_str_bambini.JPG");
        this.urlMap.put(28, "http://www.santaluciacava.it/images/segn_str_DOPPIO%20SENSO%20DI%20CIRCOLAZIONE%20SU%20STRADA%20A%20SENSO%20UNICO.JPG");
        this.urlMap.put(29, "http://www.santaluciacava.it/images/segn_str_rotatoria.JPG");
        this.urlMap.put(31, "http://www.santaluciacava.it/images/segn_str_materiale%20instabile%20sulla%20strada.JPG");
        this.urlMap.put(33, "http://www.santaluciacava.it/images/segn_str_CADUTA%20MASSI%20VERSO%20DESTRA.JPG");
        this.urlMap.put(34, "http://www.santaluciacava.it/images/segn_str_semaforo%20triangolo.JPG");
        this.urlMap.put(47, "http://www.santaluciacava.it/images/segn_str_intersezione%20con%20diritto%20di%20precedenza.JPG");
    }

    public static String getUrl(int key){
        return urlMap.get(key);
    }
}
