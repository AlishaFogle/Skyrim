package skyrim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import skyrim.helpers.Images;

/**
 * Class: Skyrim
 * Package: skyrim
 * @author Alisha
 * @since 
 * @version
 * 
 */
public class Skyrim extends JFrame implements ActionListener{
    
    private final Images images = new Images();
    
    public Skyrim() {

        setTitle("Skyrim");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(images.getIcons("Skyrim_Icon"));
        initComponents();
        setVisible(true);        
    }
    public static void main(String[] args) {
        new Skyrim();
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch (ClassNotFoundException ex) {} 
        catch (InstantiationException ex) {}
        catch (IllegalAccessException ex) {}
        catch (UnsupportedLookAndFeelException ex) {}
    }

    private void initComponents() {
        setMenuBar();
        
        JLabel image = new JLabel(images.getImages(Images.SKYRIM_WALL));
        add(image);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "exit":
                setVisible(false);
                dispose();
                break;
        }
    }

    private void setMenuBar() {
        JMenuBar mb = new JMenuBar();
        JMenu apps = new JMenu("Apps");
        JMenuItem alchemy = new JMenuItem("Alchemy");
        JMenuItem enchanting = new JMenuItem("Enchanting");
        JMenuItem smithing = new JMenuItem("Smithing");
        JMenuItem exit = new JMenuItem("Exit");
        alchemy.setEnabled(false);
        alchemy.setActionCommand("alchemy");
        alchemy.addActionListener(this);
        enchanting.setEnabled(false);
        enchanting.setActionCommand("enchant");
        enchanting.addActionListener(this);
        smithing.setEnabled(false);
        smithing.setActionCommand("smithing");
        smithing.addActionListener(this);
        exit.setEnabled(true);
        exit.setActionCommand("exit");
        exit.addActionListener(this);
        
        apps.add(alchemy);
        apps.add(enchanting);
        apps.add(smithing);
        apps.addSeparator();
        apps.add(exit);
        mb.add(apps);
        setJMenuBar(mb);
    }


}
