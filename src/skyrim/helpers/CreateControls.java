package skyrim.helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
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
    
    public static final String SKYRIMBOOKS_GAELIC = "SkyrimBooks_Gaelic";
    public static final String SKYRIMBOOKS_HANDWRITTEN_BOLD = "SkyrimBooks_Handwritten_Bold";
    
    /**
     * Font myFont method.
     * @param name
     * @return 
     */
    private static Font myFont(String name, int style, int size) {
        String fontName = "/skyrim/font/" + name + ".ttf";
        File fontFile = new File(fontName);
        Font font = new Font("Calibri", style, size);
        
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
        panel.setMaximumSize(dims);
        panel.setMinimumSize(dims);
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
        label.setMaximumSize(dims);
        label.setMinimumSize(dims);
        label.setPreferredSize(dims);
        label.setFont(myFont("Calibri", Font.PLAIN, 14));
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
    public static JTextField createTextField(int cols, boolean enable, String fontName, int style, int size) {
        Dimension dims = new Dimension(60,25);
        JTextField textField = new JTextField();
        textField.setFont(myFont(fontName, style, size));
        textField.setColumns(cols);
        textField.setEditable(enable);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        textField.setMaximumSize(dims);
        textField.setMinimumSize(dims);
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
    public static JRadioButton createRadioButton(String text, int width, int height, boolean selected, boolean border, String fontname, int style, int size) {
        Dimension dims = new Dimension(width, height);
        JRadioButton rdo = new JRadioButton(text, selected);
        rdo.setMaximumSize(dims);
        rdo.setMinimumSize(dims);
        rdo.setPreferredSize(dims);
        rdo.setActionCommand(text);
        rdo.setFont(myFont(fontname, style, size));
        if(border) {
            rdo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        }
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
        Dimension dims = new Dimension(width, height);
        JCheckBox cb = new JCheckBox(text, selected);
        cb.setMaximumSize(dims);
        cb.setMinimumSize(dims);
        cb.setPreferredSize(dims);
        cb.setActionCommand(text);
        cb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        return cb;
    }
    
    /**
     * JButton createButton method.
     * @param text
     * @param width
     * @param height
     * @return 
     */
    public static JButton createButton(String text, int width, int height) {
        Dimension dims = new Dimension(width, height);
        JButton button = new JButton(text);
        button.setMaximumSize(dims);
        button.setMinimumSize(dims);
        button.setPreferredSize(dims);
        button.setActionCommand(text);
        
        return button;
    }
    
    public static JComboBox createList(String actionCommand, String[] data, int width, int height, String font, int style, int size) {
        Dimension dims = new Dimension(width, height);        
        JComboBox list = new JComboBox(data);
        list.setActionCommand(actionCommand);
        list.setMaximumSize(dims);
        list.setMinimumSize(dims);
        list.setPreferredSize(dims);
        list.setFont(myFont(font,style,size));
        return list;
    }
    
    
}
