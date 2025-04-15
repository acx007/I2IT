import java.io.*;
import java.net.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println("InetAddress of Local Host : " + address1);

        InetAddress address2 = InetAddress.getByName("127.0.0.1");
        System.out.println("InetAddress of Named Host : " + address2);

        InetAddress address3[] = InetAddress.getAllByName("127.0.0.1");
        for (int i = 0; i < address3.length; i++) {
            System.out.println( "ALL InetAddresses of Named Host : " + address3[i]);
        }

        byte IPAddress[] = { 125, 0, 0, 1 };
        InetAddress address4 = InetAddress.getByAddress(IPAddress);
        System.out.println( "InetAddresses of Host with specified IP Address : " + address4);
    }
}