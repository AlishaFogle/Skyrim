package skyrim;

import java.awt.Color;
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
public class Skyrim extends JFrame implements ActionListener {

    private final Images images = new Images();
    
    public Skyrim() {
        setUndecorated(true);
        setLocation(50,10);
        setTitle("Skyrim");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Images.getIcons("Skyrim_Icon"));
        initComponents();
        setVisible(true);        
    }
    
    private void initComponents() {
        createLookAndFeel();
        setMenuBar();
        
        JLabel image = new JLabel(Images.getImages(Images.SKYRIM_WALL));
        add(image);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "alchemy":
                setVisible(false);
                new Alchemy();
                dispose();
                break;
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
        alchemy.setEnabled(true);
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
    
    private void createLookAndFeel() {
        Color LightSeaGreen = new Color(32, 178, 170);
        Color DarkSlateBlue = new Color(72, 61, 139);
        Color SlateBlue = new Color(106, 90, 205);
        UIManager.put("nimbusBase", DarkSlateBlue);
        UIManager.put("nimbusBlueGrey", DarkSlateBlue);
        UIManager.put("control", SlateBlue);
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch (ClassNotFoundException ex) {} 
        catch (InstantiationException ex) {}
        catch (IllegalAccessException ex) {}
        catch (UnsupportedLookAndFeelException ex) {}
        
    }
    
    public static void main(String[] args) {
        new Skyrim();
        
        
        
    }

}
