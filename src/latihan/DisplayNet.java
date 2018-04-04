/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author data
 */
public class DisplayNet {

    /**
     * @param args the command line arguments
     */
    public static void main(String argv[]) 
        // TODO code application logic here
         throws Exception {
        
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while(e.hasMoreElements()){
            NetworkInterface netface=(NetworkInterface)e.nextElement();
            System.out.println("Net Interface: "+netface.getName());
            
            Enumeration e2= netface.getInetAddresses();
            while(e2.hasMoreElements()){
                InetAddress ip=(InetAddress)e2.nextElement();
                System.out.println("IP Addess:"+ip.toString());
            }
        }
        System.out.println("");
        System.out.println("Nama : aji prasetyo");
        System.out.println("Kelas : 4cb");
    }
    
}
