/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author data
 */
public class ChatServer extends JFrame {
    JLabel lblnama = new JLabel("Nama : Aji Prasetyo");
    JLabel lblkelas = new JLabel(" 4CB Teknik Komputer");
    JLabel lblPesan = new JLabel("Kirim Pesan : ");
    TextArea taPesan = new TextArea(4,50);
    JLabel lblBalasan = new JLabel ("Dari Teman: ");
    TextArea taBalasan = new TextArea(4,50);
    JButton btnSend = new JButton ("Send");
    JButton btnClose = new JButton ("Close Connection");
    
    ImageIcon foto = new ImageIcon("E:\\icon.png");
    
    ServerSocket sktServer;
    Socket conClient;
    
    
ObjectInputStream fromClient;
ObjectOutputStream toClient;
String s=null;
Container c;

public void sendData(){
    try{
        toClient = new ObjectOutputStream(conClient.getOutputStream());
        toClient.writeObject(taPesan.getText());
        System.out.println(taPesan.getText());
        taPesan.requestFocus();
    }
    catch(EOFException ex) {
        ;
}
    catch(NullPointerException se){
        JOptionPane.showMessageDialog(null,"Koneksi Putus !",
        "Pesan", JOptionPane.ERROR_MESSAGE);
    }
    catch (IOException io){
        System.out.println("IO Exception");
        io.printStackTrace();
    }}

    public void closeConnection(){
       try{
           conClient.close();
           conClient = null;
           System.exit(0);
       }
    catch (EOFException ex){
        ;
    }
       catch (IOException io){
           System.out.println("IO Exception");
           io.printStackTrace();
       }
    }
    
    public ChatServer()throws IOException{
        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(lblPesan);
        c.add(taPesan);
        c.add(lblBalasan);
        c.add(taBalasan);
        c.add (btnSend);
        c.add (btnClose);
        System.out.println("");
        c.add(lblnama);
        c.add(lblkelas);
        
        c.add(new JLabel(foto));
        btnSend.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
        sendData();
        }
        });
        
        btnClose.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            closeConnection();
        }
        });
        }
    
        public void terimaKoneksi() throws IOException{
        sktServer = new ServerSocket(2000);
        conClient = sktServer.accept();
        JOptionPane.showMessageDialog(null, "Tersambung dengan Client"+
        conClient.getInetAddress().toString(), "Pesan" , JOptionPane.INFORMATION_MESSAGE);
        sktServer.close();
        
        try{
        fromClient =new ObjectInputStream(conClient.getInputStream());
        do {
        try{
        s=(String) fromClient.readObject();
        taBalasan.setText(s);
        }
        
        catch(ClassNotFoundException ex){
        System.out.println("Error");
        }
        }
        while(!s.equals("bye"));
        }
        catch (EOFException ex){
            ;
        }
        catch (IOException io){
        System.out.println("IO Exception");
        io.printStackTrace();
        }
        finally {
        System.out.println("Closed");
        conClient.close();
        }
        }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    ChatServer svr = new ChatServer();
    svr.setTitle("Chatting - Server");
    svr.setLocation(300,300);
    svr.setSize(400,500);
    svr.setVisible(true);
    svr.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent ev){
    System.exit(0);
    }
    });
    svr.terimaKoneksi();
    }
        // TODO code application logic here
    }
    
