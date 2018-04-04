/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;
import java.net.*;
/**
 *
 * @author data
 */
public class Latihan { 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try{
        InetAddress ip = InetAddress.getByName("localhost");
        
    System.out.println(ip.getHostAddress());
    System.out.println(ip.getHostName());
    }
    catch(UnknownHostException e){
        System.out.println(e);}
    
        System.out.println("");
        System.out.println("Nama : Aji Prasetyo");
        System.out.println("Kelas: 4cb");
        // TODO code application logic here
    }
    
    
}
 