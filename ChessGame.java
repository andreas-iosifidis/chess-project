
package chessgame;

import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author antre
 */
public class ChessGame {

    
    public static void main(String[] args) {
     JFrame frame=new JFrame();
     Board a= new Board();
    frame.add(a);
    
    frame.setSize(1200, 1000);
   
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Chess");
    frame.setVisible(true);
    
     
    }
    
}
