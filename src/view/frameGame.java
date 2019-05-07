
package view;

import controller.Principal;
import javax.swing.JFrame;
import model.movimento;


public class frameGame extends Principal{
    
    
    public frameGame(int width, int height, String titulo){
        
        JFrame frame = new JFrame();
        movimento g = new movimento(width, height);
        frame.add(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setTitle(titulo);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        
 
    }

    
}
