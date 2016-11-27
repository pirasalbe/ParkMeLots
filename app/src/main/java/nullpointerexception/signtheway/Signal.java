package nullpointerexception.signtheway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 26/11/2016.
 */
public class Signal {
    private int key, codSignal;
    private double lat, lon;
    private static Map<String, List<Integer>> signalTypeMap = new HashMap<String, List<Integer>>();
    static{
        List<Integer> codesListPericolo = new ArrayList<Integer>();
        List<Integer> codesListPrecedenza = new ArrayList<Integer>();
        codesListPericolo.add(1);
        codesListPericolo.add(2);
        codesListPericolo.add(3);
        codesListPericolo.add(5);
        codesListPericolo.add(7);
        codesListPericolo.add(8);
        codesListPericolo.add(9);
        codesListPericolo.add(10);
        codesListPericolo.add(11);
        codesListPericolo.add(15);
        codesListPericolo.add(17);
        codesListPericolo.add(18);
        codesListPericolo.add(19);
        codesListPericolo.add(21);
        codesListPericolo.add(23);
        codesListPericolo.add(24);
        codesListPericolo.add(25);
        codesListPericolo.add(28);
        codesListPericolo.add(29);
        codesListPericolo.add(31);
        codesListPericolo.add(33);
        codesListPericolo.add(34);
        codesListPericolo.add(47);
        codesListPrecedenza.add(40);
        codesListPrecedenza.add(41);
        codesListPrecedenza.add(50);
        signalTypeMap.put("PERICOLO", codesListPericolo);
        signalTypeMap.put("PRECEDENZA", codesListPrecedenza);
    }
    public Signal(int key, int codSignal, double lat, double lon){
        this.key = key;
        this.codSignal = codSignal;
        this.lat = lat;
        this.lon = lon;
        //this.initSignalTypeMap();
    }

    public static List<Signal> getSignalsFromString(String signals){
        signals = signals.replace(',', '.');
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

    private void initSignalTypeMap()
    {
        signalTypeMap = new HashMap<String, List<Integer>>();
        List<Integer> codesListPericolo = new ArrayList<Integer>();
        List<Integer> codesListPrecedenza = new ArrayList<Integer>();
        codesListPericolo.add(1);
        codesListPericolo.add(2);
        codesListPericolo.add(3);
        codesListPericolo.add(5);
        codesListPericolo.add(7);
        codesListPericolo.add(8);
        codesListPericolo.add(9);
        codesListPericolo.add(10);
        codesListPericolo.add(11);
        codesListPericolo.add(15);
        codesListPericolo.add(17);
        codesListPericolo.add(18);
        codesListPericolo.add(19);
        codesListPericolo.add(21);
        codesListPericolo.add(23);
        codesListPericolo.add(24);
        codesListPericolo.add(25);
        codesListPericolo.add(28);
        codesListPericolo.add(29);
        codesListPericolo.add(31);
        codesListPericolo.add(33);
        codesListPericolo.add(34);
        codesListPericolo.add(47);
        codesListPrecedenza.add(40);
        codesListPrecedenza.add(41);
        codesListPrecedenza.add(50);
        signalTypeMap.put("PERICOLO", codesListPericolo);
        signalTypeMap.put("PRECEDENZA", codesListPrecedenza);


    }



    public static List<Integer> getCodes(String key){
        return signalTypeMap.get(key);
    }

    public static List<Integer> getCodes(List<Signal> signalList){
        List<Integer> codeList = new ArrayList<Integer>();
        for (Signal signal: signalList){
            codeList.add(signal.codSignal);
        }
        return codeList;
    }

    public static Map<String, List<Integer>> getSignalMap(List<Integer> signals){

        List<Integer> codesListPericolo = new ArrayList<Integer>();
        List<Integer> codesListPrecedenza = new ArrayList<Integer>();
        for (Integer codSignal : getCodes("PERICOLO")) {
            for(Integer cod : signals){
                if(cod.equals(codSignal)){
                    codesListPericolo.add(cod);
                }
            }
        }
        for (Integer codSignal : getCodes("PRECEDENZA")) {
            for(Integer cod : signals){
                if(cod.equals(codSignal)){
                    codesListPrecedenza.add(cod);
                }
            }
        }
        Map<String, List<Integer>> finalList = new HashMap<String, List<Integer>>();


            finalList.put("PERICOLO", codesListPericolo);
            finalList.put("PRECEDENZA", codesListPrecedenza);


        return finalList;
    }

}
