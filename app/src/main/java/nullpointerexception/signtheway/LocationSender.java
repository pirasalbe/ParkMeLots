package nullpointerexception.signtheway;

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

/**
 * Created by Marco on 26/11/2016.
 */
public class LocationSender implements Runnable {

    private double Lat, Lon;
    public List<Signal> signalList = new ArrayList<Signal>();
    public LocationSender(double Lat, double Lon){
        this.Lat = Lat;
        this.Lon = Lon;

    }
    @Override
    public void run() {
        String sLat = Double.toString(this.Lat), sLon = Double.toString(this.Lon);
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
            String strRes = new String(res, "ASCII");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
