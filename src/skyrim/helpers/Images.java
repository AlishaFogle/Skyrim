package skyrim.helpers;

import java.awt.Image;
import java.util.Hashtable;
import javax.swing.ImageIcon;

/**
 * Class: Images
 * Package: skyrim.helpers
 * @author Alisha
 * @since May 9, 2023
 * @version 1.0
 * 
 */
public class Images {
    
    // Static Key Names:
    public static final String SKYRIM_ICON = "Skyrim_Icon";
    public static final String ALCHEMY_ICON = "Alchemy_Icon";
    public static final String ENCHANTING_ICON = "Enchanting_Icon";
    public static final String SMITHING_ICON = "Alchemy_Icon";
    public static final String SKYRIM_HEADER = "Skyrim_Header";
    public static final String SKYRIM_WALL = "Skyrim_Wall";
    public static final String ALCHEMY = "Alchemy";
    public static final String ENCHANTING = "Enchanting";
    public static final String SMITHING = "Smithing";
    
    // Hashtables to hold image and icon data:
    private final Hashtable<String,Image> icons = new Hashtable<>();
    private final Hashtable<String,ImageIcon> images = new Hashtable<>();
    
    // Icon setup:
    private final ImageIcon skyrim_icon = new ImageIcon(getClass().getResource("/skyrim/icons/Skyrim_96.png"));
    private final ImageIcon alchemy_icon = new ImageIcon(getClass().getResource("/skyrim/icons/Alchemy_96.png"));
    private final ImageIcon enchanting_icon = new ImageIcon(getClass().getResource("/skyrim/icons/Enchanting_96.png"));
    private final ImageIcon smithing_icon = new ImageIcon(getClass().getResource("/skyrim/icons/Smithing_96.png"));
    
    // ImageIcons setup:
    private final ImageIcon skyrim_header = new ImageIcon(getClass().getResource("/skyrim/images/Skyrim_Header.jpg"));
    private final ImageIcon skyrim_wall = new ImageIcon(getClass().getResource("/skyrim/images/Skyrim_Wallpaper_401.jpg"));
    private final ImageIcon alchemy_image = new ImageIcon(getClass().getResource("/skyrim/images/Alchemy.png"));
    private final ImageIcon enchanting_image = new ImageIcon(getClass().getResource("/skyrim/images/Enchanting.png"));
    private final ImageIcon smithing_image = new ImageIcon(getClass().getResource("/skyrim/images/Smithing.png"));

    public Images() {
        setIcons();
        setImages();
    }
    
    private void setIcons() {
        icons.put("Skyrim_Icon", skyrim_icon.getImage());
        icons.put("Alchemy_Icon", alchemy_icon.getImage());
        icons.put("Enchanting_Icon", enchanting_icon.getImage());
        icons.put("Smithing_Icon", smithing_icon.getImage());
    }
    public Image getIcons(String key){ return icons.get(key); }
    
    private void setImages() {
        images.put("Skyrim_Header", skyrim_header);
        images.put("Skyrim_Wall", skyrim_wall);
        images.put("Alchemy", alchemy_image);
        images.put("Enchanting", enchanting_image);
        images.put("Smithing", smithing_image);
    }
    public ImageIcon getImages(String key) { return images.get(key); }
    
}
