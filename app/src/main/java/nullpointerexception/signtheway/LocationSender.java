package nullpointerexception.signtheway;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.app.Activity;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.Map;

/**
 * Created by Marco on 26/11/2016.
 */
public class LocationSender extends AsyncTask<Void, Void, String> {

    private Context context;
    private Activity activity;
    private double Lat, Lon;
    public List<Signal> signalList = new ArrayList<Signal>();

    public LocationSender(double Lat, double Lon, Context context, Activity activity){
        this.Lat = Lat;
        this.Lon = Lon;
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... params) {
        String sLat = Double.toString(this.Lat), sLon = Double.toString(this.Lon), strRes;
        byte[] res, length = new byte[4];
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("10.100.1.89", 2000), 100);

            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            ByteBuffer buffer = ByteBuffer.allocate(4).order(ByteOrder.nativeOrder());

            buffer.putInt(sLat.length());

            dOut.write(buffer.array());
            dOut.flush();
            dOut.writeBytes(sLat);
            dOut.flush();
            buffer.clear();
            buffer.putInt(sLon.length());

            dOut.write(buffer.array());
            dOut.flush();
            dOut.writeBytes(sLon);
            dOut.flush();
            dIn.read(length);

            ByteBuffer wrapped = ByteBuffer.wrap(length);
            wrapped.order(ByteOrder.LITTLE_ENDIAN);// big-endian by default
            int num = wrapped.getInt();
            res = new byte[num];
            dIn.read(res);
            strRes = new String(res, "ASCII");
            this.signalList = Signal.getSignalsFromString(strRes);
            List<Integer> listaSegnali = Signal.getCodes(this.signalList);
            Map<String, List<Integer>> finalSignalMap = Signal.getSignalMap(listaSegnali);
            if(finalSignalMap.get("PERICOLO").size() > 0){
                return "PERICOLOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!!!!!";
            }else if(finalSignalMap.get("PRECEDENZA").size() > 0){
                return "PRECEDENZAAAAAAAAAAAAAAAAAA!!!!!!!!!";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @Override
    protected void onPostExecute(String result) {
        //do somethin

    }
}
