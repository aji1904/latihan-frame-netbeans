/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author data
 */
public class TesFDialog extends Frame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TesFDialog apl = new TesFDialog();
    }
    public TesFDialog() {
        setSize(400,150);
        FileDialog fd = new FileDialog(this, "Buka Berkas");
        fd.show();
        
        setTitle("Tes FileDialog.File:"+fd.getFile());
        
        addWindowListener(new TesFDialog.PenanganKejadian());
        show();
    }
    class PenanganKejadian extends WindowAdapter {
        public void windowClosing (WindowEvent e) {
            System.exit(0);
        }
    }
}
