package skyrim;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;

/**
 * Class: Alchemy
 * Package: skyrim
 * @author Alisha
 * @since 
 * @version
 * 
 */
public class Alchemy extends JFrame implements ActionListener {
    
    // Layout setup:
    BorderLayout layout = new BorderLayout(5,5);
    
    // Setup Components:
    
    
    public Alchemy() {
        setTitle("Alchemy Calculator:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(layout);
        initComponents();
        pack();
        setVisible(true);
    }

    private void initComponents() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
