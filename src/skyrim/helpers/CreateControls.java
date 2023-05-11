package skyrim.helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class: CreateControls
 * Package: skyrim.helpers
 * @author Alisha
 * @since 
 * @version
 * 
 */
public class CreateControls {
    
    /**
     * Font myFont method.
     * @param name
     * @return 
     */
    private static Font myFont(String name) {
        String fontName = "/skyrim/font/" + name + ".ttf";
        File fontFile = new File(fontName);
        Font font = new Font("Calibri", Font.PLAIN, 14);
        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } 
        catch (FileNotFoundException ex) {
            System.err.println("Unable to load " + fontName);
        } 
        catch (FontFormatException ex) {
            System.err.println("Font " + name + " is not a vilid True Type Font.");
        } 
        catch (IOException ex) {}
        return font;
    }
    
    /**
     * JPanel createPanel method.
     * @param width
     * @param height
     * @param border
     * @return 
     */
    public static JPanel createPanel(int width, int height, boolean border) {
        Dimension dims = new Dimension(width, height);
        JPanel panel = new JPanel();
        panel.setPreferredSize(dims);
        if(border) {
            panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        }
        return panel;
    }
    
    /**
     * JLabel createLabel method.
     * @param text Label's text
     * @param width Label width
     * @param height Label height
     * @param fontName Name of the TTF you want.
     * @param align SwingConstants RIGHT, LEFT, CENTER
     * @return 
     */
    public static JLabel createLabel(String text, int width, int height, String fontName, int align) {
        Dimension dims = new Dimension(width, height);
        JLabel label = new JLabel(text);
        label.setPreferredSize(dims);
        label.setFont(myFont("Calibri"));
        label.setHorizontalAlignment(align);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }
    
    /**
     * JTextField createTextField method.
     * @param fontName Name of the Font
     * @param cols Number of Columns
     * @param enable Is it Editable (true/false)
     * @param width TextField's width
     * @param height TextField's height
     * @return 
     */
    public static JTextField createTextField(String fontName, int cols, boolean enable) {
        Dimension dims = new Dimension(60,25);
        JTextField textField = new JTextField();
        textField.setFont(myFont(fontName));
        textField.setColumns(cols);
        textField.setEditable(enable);
        textField.setPreferredSize(dims);
        return textField;
    }
    
    /**
     * JRadioButton createRadioButton method.
     * @param text
     * @param width
     * @param height
     * @param selected
     * @return
     * 
     */    
    public static JRadioButton createRadioButton(String text, int width, int height, boolean selected) {
        JRadioButton rdo = new JRadioButton(text, selected);
        rdo.setPreferredSize(new Dimension(width, height));
        rdo.setActionCommand(text);
        rdo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return rdo;
    }
    
    /**
     * JCheckBox createCheckBox method.
     * @param text
     * @param width
     * @param height
     * @param selected
     * @return 
     */
    public static JCheckBox createCheckBox(String text, int width, int height, boolean selected) {
        JCheckBox cb = new JCheckBox(text, selected);
        cb.setPreferredSize(new Dimension(width,height));
        cb.setActionCommand(text);
        return cb;
    }
}
