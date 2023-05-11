package skyrim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import skyrim.helpers.CreateControls;
import skyrim.helpers.Images;

/**
 * 
 * Class: Alchemy
 * Package: skyrim
 * @author Alisha
 * @since May 9, 2023
 * @version 1.0
 * 
 */
public class Alchemy extends JFrame implements ActionListener {
    
    private final int frame_width = 585;
    private final int frame_height = 650;
    private int northPane_width;
    private int northPane_height;
    private int westPane_width;
    private int westPane_height;
    private int centerPane_width;
    private int centerPane_height;
    
    private final Images images = new Images();
    
    /**
     * Calculation constants:
     * fAlchemyIngredientInitMult = 4
     * fAlchemySkillFactor = 1.5
     */
    private final int fAlchemyIngredientInitMult = 4;
    private final float fAlchemySkillFactor = 1.5f;
    
    private float AlchemyPerk = 1.0f;
    private float PhysicianPerk = 1.0f;
    private float BenefactorPerk = 1.0f;
    private float PoisonerPerk = 1.0f;
    private float SeekerOfShadows = 1.0f;
    private int EnchantmentTotal = 0;
    private int BaseMag = 0;
    private float BaseCost = 0.0f;
    private int PotionMag = 0;
    private int PotionCost = 0;
    
    /**
     * 
     * Create the default layout:
     * Default Layout: BorderLayout
     * 
     */
    BorderLayout layout = new BorderLayout(1,1);
    
    /**
     * 
     * Set up the variables needed for
     * JLabel, JTextField, ButtonGroup,
     * JRadioButton, JCheckbox, JPanels.
     * 
     */
    private JLabel lbl_alchemy_skill;
    private JLabel lbl_alchemy_perk;
    private JLabel lbl_physician_perk;
    private JLabel lbl_benefactor_perk;
    private JLabel lbl_poisoner_perk;
    private JLabel lbl_seeker_of_shadows;
    private JLabel lbl_ench_ring;
    private JLabel lbl_ench_amulet;
    private JLabel lbl_ench_headgear;
    private JLabel lbl_ench_hands;
    private JLabel lbl_ench_total;
    private JLabel lbl_ench_header;
    private JLabel lbl_base_mag;
    private JLabel lbl_base_dur;
    private JLabel lbl_base_gold;
    private JLabel lbl_calc_mag;
    private JLabel lbl_calc_dur;
    private JLabel lbl_calc_gold;
    
    private JTextField txt_alchemy_skill;
    private JTextField txt_alchemy_perk;
    private JTextField txt_physician_perk;
    private JTextField txt_benefactor_perk;
    private JTextField txt_poisoner_perk;
    private JTextField txt_seeker_of_shadows;
    private JTextField txt_ench_ring;
    private JTextField txt_ench_amulet;
    private JTextField txt_ench_headgear;
    private JTextField txt_ench_hands;
    private JTextField txt_ench_total;
    private JTextField txt_base_mag;
    private JTextField txt_base_dur;
    private JTextField txt_base_gold;
    private JTextField txt_calc_mag;
    private JTextField txt_calc_dur;
    private JTextField txt_calc_gold;
    
    private ButtonGroup bg = new ButtonGroup();
    
    private JRadioButton rdoNone;
    private JRadioButton rdoAlchemy1;
    private JRadioButton rdoAlchemy2;
    private JRadioButton rdoAlchemy3;
    private JRadioButton rdoAlchemy4;
    private JRadioButton rdoAlchemy5;
    
    private JCheckBox chk_physician;
    private JCheckBox chk_benefactor;
    private JCheckBox chk_poisoner;
    private JCheckBox chk_seeker_of_shadows;
    
    private JPanel northPane;
    private JPanel westPane;
    private JPanel labels;
    private JPanel textFields;
    private JPanel centerPane;
    private JPanel eastPane;
    private JPanel southPane;
    
    /**
     * Set up the default constructor:
     */
    public Alchemy() {
       
        setTitle("Alchemy Calculator:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(layout);
        setIconImage(images.getIcons(Images.ALCHEMY_ICON));
        setLocation(50, 10);
//        setMaximumSize(new Dimension(frame_width, frame_height));
//        setPreferredSize(new Dimension(frame_width, frame_height));
        setResizable(false);
        setUndecorated(true);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        
        setJMenuBar();
        northPane();
        westPane();
        centerPane();
        
        add(BorderLayout.NORTH, northPane);
        add(BorderLayout.WEST, westPane);
        add(BorderLayout.CENTER, centerPane);

        pack();
    }   

    private void northPane() {
        
        northPane = CreateControls.createPanel(frame_width - 2, 220, true);
        northPane.setBackground(Color.BLACK);
        
        JLabel header = new JLabel(images.getImages(Images.ALCHEMY_HEADER));
        JLabel header_icon = new JLabel(images.getImages(Images.ALCHEMY));
        header.setPreferredSize(new Dimension(275, 95));
        header_icon.setPreferredSize(new Dimension(210, 210));
        
        if(header.getPreferredSize().height > header_icon.getPreferredSize().height) {
            northPane_height = header.getPreferredSize().height + 2;
        } else {
            northPane_height = header_icon.getPreferredSize().height + 2;
        }
        
        northPane_width = frame_width - 2;
        northPane = CreateControls.createPanel(northPane_width, northPane_height, true);
        northPane.setBackground(Color.BLACK);
        northPane.add(BorderLayout.WEST, header);
        northPane.add(BorderLayout.EAST, header_icon);
        pack();
    }

    private void westPane() {
        westPane_width = 190;
        westPane_height = 305;
        
        westPane = CreateControls.createPanel(westPane_width, westPane_height, true);

        lbl_alchemy_perk = CreateControls.createLabel("Alchemy Perk: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_alchemy_perk.setLabelFor(txt_alchemy_perk);
        lbl_physician_perk = CreateControls.createLabel("Physician Perk: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_physician_perk.setLabelFor(txt_physician_perk);
        lbl_benefactor_perk = CreateControls.createLabel("Benefactor Perk: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_benefactor_perk.setLabelFor(txt_benefactor_perk);
        lbl_poisoner_perk = CreateControls.createLabel("Poisoner Perk: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_poisoner_perk.setLabelFor(txt_poisoner_perk);
        lbl_seeker_of_shadows = CreateControls.createLabel("Seeker Of Shadows: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_seeker_of_shadows.setLabelFor(txt_seeker_of_shadows);
        lbl_ench_total = CreateControls.createLabel("Enchantment Total: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_ench_total.setLabelFor(txt_ench_total);
        lbl_base_mag = CreateControls.createLabel("Base Magnitude: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_base_mag.setLabelFor(txt_base_mag);
        lbl_base_gold = CreateControls.createLabel("Base Gold Value: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_base_gold.setLabelFor(txt_base_gold);
        lbl_calc_mag = CreateControls.createLabel("Potion Magnitude: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_calc_mag.setLabelFor(txt_calc_mag);
        lbl_calc_gold = CreateControls.createLabel("Potion Gold Value: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_calc_gold.setLabelFor(txt_calc_gold);
        
        txt_alchemy_perk = CreateControls.createTextField("Calibri", 4, false);
        txt_alchemy_perk.setText("0%");
        txt_physician_perk = CreateControls.createTextField("Calibri", 4, false);
        txt_physician_perk.setText("0%");
        txt_benefactor_perk = CreateControls.createTextField("Calibri", 4, false);
        txt_benefactor_perk.setText("0%");
        txt_poisoner_perk = CreateControls.createTextField("Calibri", 4, false);
        txt_poisoner_perk.setText("0%");
        txt_seeker_of_shadows = CreateControls.createTextField("Calibri", 4, false);
        txt_seeker_of_shadows.setText("0%");
        txt_ench_total = CreateControls.createTextField("Calibri", 4, false);
        txt_ench_total.setText("0");
        txt_base_mag = CreateControls.createTextField("Calibri", 4, false);
        txt_base_mag.setText("0");
        txt_base_gold = CreateControls.createTextField("Calibri", 4, false);
        txt_base_gold.setText("0");
        txt_calc_mag = CreateControls.createTextField("Calibri", 4, false);
        txt_calc_mag.setText("0");
        txt_calc_gold = CreateControls.createTextField("Calibri", 4, false);
        txt_calc_gold.setText("0");
        
        // Column 1:
        westPane.add(lbl_alchemy_perk);
        westPane.add(txt_alchemy_perk);
        westPane.add(lbl_physician_perk);
        westPane.add(txt_physician_perk);
        westPane.add(lbl_benefactor_perk);
        westPane.add(txt_benefactor_perk);
        westPane.add(lbl_poisoner_perk);
        westPane.add(txt_poisoner_perk);
        westPane.add(lbl_seeker_of_shadows);
        westPane.add(txt_seeker_of_shadows);
        westPane.add(lbl_ench_total);
        westPane.add(txt_ench_total);
        westPane.add(lbl_base_mag);
        westPane.add(txt_base_mag);
        westPane.add(lbl_base_gold);
        westPane.add(txt_base_gold);
        westPane.add(lbl_calc_mag);
        westPane.add(txt_calc_mag);
        westPane.add(lbl_calc_gold);
        westPane.add(txt_calc_gold);
        
        pack();
    }

    private void centerPane() {
        int center_west_pane_width = 180;
        int comp_width = 150;
        
        centerPane_width = (frame_width - 2) - (westPane_width - 2);
        centerPane_height = westPane_height;
        
        centerPane = CreateControls.createPanel(centerPane_width, centerPane_height, true);
        JPanel center_west_panel = CreateControls.createPanel(center_west_pane_width, (centerPane_height - 2), true);
        JPanel center_east_panel = CreateControls.createPanel(comp_width + 2, (centerPane_height - 2), true);
                
        lbl_alchemy_skill = CreateControls.createLabel("Alchemy Skill: ", 90,25, "Calibri", SwingConstants.RIGHT);
        lbl_alchemy_skill.setLabelFor(txt_alchemy_skill);
        txt_alchemy_skill = CreateControls.createTextField("Calibri", 4, true);
        lbl_ench_header = CreateControls.createLabel("Enchantments: ", 151,25, "Calibri", SwingConstants.CENTER);
        lbl_ench_ring = CreateControls.createLabel("Ring: ", 90,25, "Calibri", SwingConstants.RIGHT);
        lbl_ench_ring.setLabelFor(txt_ench_ring);
        txt_ench_ring = CreateControls.createTextField("Calibri", 4, true);
        lbl_ench_amulet = CreateControls.createLabel("Amulet: ", 90,25, "Calibri", SwingConstants.RIGHT);
        lbl_ench_amulet.setLabelFor(txt_ench_amulet);
        txt_ench_amulet = CreateControls.createTextField("Calibri", 4, true);
        lbl_ench_headgear = CreateControls.createLabel("Head Gear: ", 90,25, "Calibri", SwingConstants.RIGHT);
        lbl_ench_headgear.setLabelFor(txt_ench_headgear);
        txt_ench_headgear = CreateControls.createTextField("Calibri", 4, true);
        lbl_ench_hands = CreateControls.createLabel("Hands: ", 90,25, "Calibri", SwingConstants.RIGHT);
        lbl_ench_hands.setLabelFor(txt_ench_hands);
        txt_ench_hands = CreateControls.createTextField("Calibri", 4, true);
        
        rdoNone = CreateControls.createRadioButton("None", comp_width, 25, true);
        rdoNone.addActionListener(this);
        rdoAlchemy1 = CreateControls.createRadioButton("Alchemy 1", comp_width, 25, false);
        rdoAlchemy1.addActionListener(this);
        rdoAlchemy2 = CreateControls.createRadioButton("Alchemy 2", comp_width, 25, false);
        rdoAlchemy2.addActionListener(this);
        rdoAlchemy3 = CreateControls.createRadioButton("Alchemy 3", comp_width, 25, false);
        rdoAlchemy3.addActionListener(this);
        rdoAlchemy4 = CreateControls.createRadioButton("Alchemy 4", comp_width, 25, false);
        rdoAlchemy4.addActionListener(this);
        rdoAlchemy5 = CreateControls.createRadioButton("Alchemy 5", comp_width, 25, false);
        rdoAlchemy5.addActionListener(this);
        
        bg.add(rdoNone);
        bg.add(rdoAlchemy1);
        bg.add(rdoAlchemy2);
        bg.add(rdoAlchemy3);
        bg.add(rdoAlchemy4);
        bg.add(rdoAlchemy5);
        
        chk_physician = CreateControls.createCheckBox("Physician Perk", comp_width, 25, false);
        chk_physician.addActionListener(this);
        chk_benefactor = CreateControls.createCheckBox("Benefactor Perk", comp_width, 25, false);
        chk_benefactor.addActionListener(this);
        chk_poisoner = CreateControls.createCheckBox("Poisoner Perk", comp_width, 25, false);
        chk_poisoner.addActionListener(this);
        chk_seeker_of_shadows = CreateControls.createCheckBox("Seeker Of Shadows", comp_width, 25, false);
        chk_seeker_of_shadows.addActionListener(this);
        
        center_west_panel.add(lbl_alchemy_skill);
        center_west_panel.add(txt_alchemy_skill);
        center_west_panel.add(lbl_ench_header);
        center_west_panel.add(lbl_ench_ring);
        center_west_panel.add(txt_ench_ring);
        center_west_panel.add(lbl_ench_amulet);
        center_west_panel.add(txt_ench_amulet);
        center_west_panel.add(lbl_ench_headgear);
        center_west_panel.add(txt_ench_headgear);
        center_west_panel.add(lbl_ench_hands);
        center_west_panel.add(txt_ench_hands);
        
        center_east_panel.add(rdoNone);
        center_east_panel.add(rdoAlchemy1);
        center_east_panel.add(rdoAlchemy2);
        center_east_panel.add(rdoAlchemy3);
        center_east_panel.add(rdoAlchemy4);
        center_east_panel.add(rdoAlchemy5);

        center_east_panel.add(chk_physician);
        center_east_panel.add(chk_benefactor);
        center_east_panel.add(chk_poisoner);
        center_east_panel.add(chk_seeker_of_shadows);
        
        centerPane.add(BorderLayout.WEST,center_west_panel );
        centerPane.add(BorderLayout.CENTER, center_east_panel);
        pack();
    }

    private void eastPane() {
        eastPane = new JPanel();
        eastPane.setMaximumSize(new Dimension(100, 100));
        eastPane.setPreferredSize(new Dimension(100, 100));
        eastPane.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2, true));
        eastPane.setBackground(Color.DARK_GRAY);
        eastPane.setForeground(Color.DARK_GRAY);
    }

    private void southPane() {
        southPane = new JPanel();
        southPane.setMaximumSize(new Dimension(300, 100));
        southPane.setMinimumSize(new Dimension(300, 100));
        southPane.setPreferredSize(new Dimension(300, 100));
        southPane.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2, true));
        southPane.setBackground(Color.BLUE);
        southPane.setForeground(Color.GREEN);
    }

    private void setJMenuBar() {
        JMenuBar mb = new JMenuBar();
        JMenu apps = new JMenu("Apps");
        JMenuItem skyrim = new JMenuItem("Skyrim");
        JMenuItem enchanting = new JMenuItem("Enchanting");
        JMenuItem smithing = new JMenuItem("Smithing");
        JMenuItem exit = new JMenuItem("Exit");
        skyrim.setEnabled(true);
        skyrim.setActionCommand("skyrim");
        skyrim.addActionListener(this);
        enchanting.setEnabled(false);
        enchanting.setActionCommand("enchant");
        enchanting.addActionListener(this);
        smithing.setEnabled(false);
        smithing.setActionCommand("smithing");
        smithing.addActionListener(this);
        exit.setEnabled(true);
        exit.setActionCommand("exit");
        exit.addActionListener(this);
        
        apps.add(skyrim);
        apps.add(enchanting);
        apps.add(smithing);
        apps.addSeparator();
        apps.add(exit);
        mb.add(apps);
        setJMenuBar(mb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "skyrim":
                setVisible(false);
                new Skyrim();
                dispose();
                break;
            case "exit":
                setVisible(false);
                dispose();
                break;
            case "None":
                txt_alchemy_perk.setText("0%");
                break;
            case "Alchemy 1":
                AlchemyPerk = 1.20f;
                txt_alchemy_perk.setText("20%");
                break;
            case "Alchemy 2":
                AlchemyPerk = 1.40f;
                txt_alchemy_perk.setText("40%");
                break;
            case "Alchemy 3":
                AlchemyPerk = 1.60f;
                txt_alchemy_perk.setText("60%");
                break;
            case "Alchemy 4":
                AlchemyPerk = 1.80f;
                txt_alchemy_perk.setText("80%");
                break;
            case "Alchemy 5":
                AlchemyPerk = 2.0f;
                txt_alchemy_perk.setText("100%");
                break;
            case "Physician Perk":
                if(chk_physician.isSelected()) {
                    PhysicianPerk = 1.25f;
                    txt_physician_perk.setText("25%");
                    break;
                } else {
                    PhysicianPerk = 1.0f;
                    txt_physician_perk.setText("0%");
                    break;
                }
                
            case "Benefactor Perk":
                if(chk_benefactor.isSelected()) {
                    BenefactorPerk = 1.25f;
                    txt_benefactor_perk.setText("25%");
                    break;
                } else {
                    BenefactorPerk = 1.0f;
                    txt_benefactor_perk.setText("0%");
                    break;
                }
                
            case "Poisoner Perk":
                if(chk_poisoner.isSelected()) {
                    PoisonerPerk = 1.25f;
                    txt_poisoner_perk.setText("25%");
                    break;
                } else {
                    PoisonerPerk = 1.0f;
                    txt_poisoner_perk.setText("0%");
                    break;
                }
                
            case "Seeker Of Shadows":
                if(chk_seeker_of_shadows.isSelected()) {
                    SeekerOfShadows = 1.1f;
                    txt_seeker_of_shadows.setText("10%");
                    break;
                } else {
                    SeekerOfShadows = 1.0f;
                    txt_seeker_of_shadows.setText("0%");
                    break;
                }
                
        }
    }
}
