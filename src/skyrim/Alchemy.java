package skyrim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import skyrim.helpers.CreateControls;
import skyrim.helpers.DataFile;
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
    
    private static final int frame_width = 490;
    private static final int frame_height = 660;
    private int northPane_width;
    private int northPane_height;
    private int westPane_width;
    private int westPane_height;
    private int centerPane_width;
    private int centerPane_height;
    
    private final Images images = new Images();
    private final DataFile df = new DataFile();
    /**
     * Calculation constants:
     * fAlchemyIngredientInitMult = 4
     * fAlchemySkillFactor = 1.5
     */
    private final int fAlchemyIngredientInitMult = 4;
    private final float fAlchemySkillFactor = 1.5f;
    
    private Double AlchemyPerk = 1.0;
    private Double PhysicianPerk = 1.0;
    private Double BenefactorPerk = 1.0;
    private Double PoisonerPerk = 1.0;
    private Double SeekerOfShadows = 1.0;
    private Double EnchantmentTotal = 1.0;
    private int Duration = 0;
    private int BaseMag = 0;
    private int BaseDur = 0;
    private Double BaseCost = 0.0;
    private int PotionMag = 0;
    private int PotionDur = 0;
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
    
    private JComboBox effectList;
    
    private JPanel northPane;
    private JPanel westPane;
    private JPanel centerPane;
    private JPanel eastPane;

    
    /**
     * Set up the default constructor:
     */
    public Alchemy() {

        setTitle("Alchemy Calculator:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(layout);
        setIconImage(images.getIcons(Images.ALCHEMY_ICON));
        setLocation(50, 10);
        setResizable(true);
        setUndecorated(false);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        
        setJMenuBar();
        northPane();
        westPane();
        centerPane();
        eastPane();
        
        add(BorderLayout.NORTH, northPane);
        add(BorderLayout.WEST, westPane);
        add(BorderLayout.CENTER, centerPane);
        add(BorderLayout.EAST, eastPane);

        pack();
    }   

    private void northPane() {
        
        JLabel header = new JLabel(Images.getImages(Images.ALCHEMY_HEADER));
        JLabel header_icon = new JLabel(Images.getImages(Images.ALCHEMY));
        header.setPreferredSize(new Dimension(270, 95));
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
        westPane_height = 370;
        
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
        lbl_base_dur = CreateControls.createLabel("Base Duration: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_base_dur.setLabelFor(txt_base_dur);
        lbl_base_gold = CreateControls.createLabel("Base Gold Value: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_base_gold.setLabelFor(txt_base_gold);
        lbl_calc_mag = CreateControls.createLabel("Potion Magnitude: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_calc_mag.setLabelFor(txt_calc_mag);
        lbl_calc_dur = CreateControls.createLabel("Potion Duration: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_calc_dur.setLabelFor(txt_calc_dur);
        lbl_calc_gold = CreateControls.createLabel("Potion Gold Value: ", 120,25, "Calibri", SwingConstants.RIGHT);
        lbl_calc_gold.setLabelFor(txt_calc_gold);
        
        txt_alchemy_perk = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_alchemy_perk.setText("0%");
        txt_alchemy_perk.setEditable(false);
        txt_physician_perk = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_physician_perk.setText("0%");
        txt_physician_perk.setEditable(false);
        txt_benefactor_perk = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_benefactor_perk.setText("0%");
        txt_benefactor_perk.setEditable(false);
        txt_poisoner_perk = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_poisoner_perk.setText("0%");
        txt_poisoner_perk.setEditable(false);
        txt_seeker_of_shadows = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_seeker_of_shadows.setText("0%");
        txt_seeker_of_shadows.setEditable(false);
        txt_ench_total = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_ench_total.setText("0");
        txt_ench_total.setEditable(false);
        txt_base_mag = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_base_mag.setText("0");
        txt_base_mag.setEditable(false);
        txt_base_dur = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_base_dur.setText("0");
        txt_base_dur.setEditable(false);
        txt_base_gold = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_base_gold.setText("0.0");
        txt_base_gold.setEditable(false);
        txt_calc_mag = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_calc_mag.setText("0");
        txt_calc_mag.setEditable(false);
        txt_calc_dur = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_calc_dur.setText("0");
        txt_calc_dur.setEditable(false);
        txt_calc_gold = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        txt_calc_gold.setText("0");
        txt_calc_gold.setEditable(false);
        
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
        westPane.add(lbl_base_dur);
        westPane.add(txt_base_dur);
        westPane.add(lbl_base_gold);
        westPane.add(txt_base_gold);
        westPane.add(lbl_calc_mag);
        westPane.add(txt_calc_mag);
        westPane.add(lbl_calc_dur);
        westPane.add(txt_calc_dur);
        westPane.add(lbl_calc_gold);
        westPane.add(txt_calc_gold);
        pack();
    }

    private void centerPane() {
        
        int comp_width = 150;
                        
        lbl_alchemy_skill = CreateControls.createLabel("Alchemy Skill: ", 90,25, "Calibri", SwingConstants.RIGHT);
        txt_alchemy_skill = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        lbl_ench_header = CreateControls.createLabel("Enchantments: ", 145,25, "Calibri", SwingConstants.CENTER);
        lbl_ench_ring = CreateControls.createLabel("Ring: ", 90,25, "Calibri", SwingConstants.RIGHT);
        txt_ench_ring = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        lbl_ench_amulet = CreateControls.createLabel("Amulet: ", 90,25, "Calibri", SwingConstants.RIGHT);
        txt_ench_amulet = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        lbl_ench_headgear = CreateControls.createLabel("Head Gear: ", 90,25, "Calibri", SwingConstants.RIGHT);
        txt_ench_headgear = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        lbl_ench_hands = CreateControls.createLabel("Hands: ", 90,25, "Calibri", SwingConstants.RIGHT);
        txt_ench_hands = CreateControls.createTextField(4, true, "Calibri", Font.PLAIN, 14);
        
        lbl_alchemy_skill.setLabelFor(txt_alchemy_skill);
        lbl_ench_ring.setLabelFor(txt_ench_ring);
        lbl_ench_amulet.setLabelFor(txt_ench_amulet);
        lbl_ench_headgear.setLabelFor(txt_ench_headgear);
        lbl_ench_hands.setLabelFor(txt_ench_hands);
        
        JButton enchantCalc = CreateControls.createButton("Ench Total", 100, 25);
        JButton potionCalc = CreateControls.createButton("Potion Calc", 100, 25);
        
        enchantCalc.addActionListener(this);
        potionCalc.addActionListener(this);
        
        effectList = CreateControls.createList("Effect List", df.getKeys(), 145, 25, CreateControls.SKYRIMBOOKS_GAELIC, Font.PLAIN, 14);
        effectList.addActionListener(this);
        
        centerPane = CreateControls.createPanel(153, 305, true);
        centerPane.add(effectList);
        centerPane.add(lbl_alchemy_skill);
        centerPane.add(txt_alchemy_skill);
        centerPane.add(lbl_ench_header);
        centerPane.add(lbl_ench_ring);
        centerPane.add(txt_ench_ring);
        centerPane.add(lbl_ench_amulet);
        centerPane.add(txt_ench_amulet);
        centerPane.add(lbl_ench_headgear);
        centerPane.add(txt_ench_headgear);
        centerPane.add(lbl_ench_hands);
        centerPane.add(txt_ench_hands);
        centerPane.add(BorderLayout.CENTER,enchantCalc);
        centerPane.add(BorderLayout.CENTER,potionCalc);
        pack();
    }

    private void eastPane() {
        int comp_width = 150;
        int comp_height = 25;
        
        rdoNone = CreateControls.createRadioButton("None", comp_width, 25, true, false, "Calibri", Font.PLAIN, 14);
        rdoNone.addActionListener(this);
        rdoAlchemy1 = CreateControls.createRadioButton("Alchemy 1", comp_width, 25, false, false, "Calibri", Font.PLAIN, 14);
        rdoAlchemy1.addActionListener(this);
        rdoAlchemy2 = CreateControls.createRadioButton("Alchemy 2", comp_width, 25, false, false, "Calibri", Font.PLAIN, 14);
        rdoAlchemy2.addActionListener(this);
        rdoAlchemy3 = CreateControls.createRadioButton("Alchemy 3", comp_width, 25, false, false, "Calibri", Font.PLAIN, 14);
        rdoAlchemy3.addActionListener(this);
        rdoAlchemy4 = CreateControls.createRadioButton("Alchemy 4", comp_width, 25, false, false, "Calibri", Font.PLAIN, 14);
        rdoAlchemy4.addActionListener(this);
        rdoAlchemy5 = CreateControls.createRadioButton("Alchemy 5", comp_width, 25, false, false, "Calibri", Font.PLAIN, 14);
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
        
        eastPane = CreateControls.createPanel( (comp_width + 2), 305, true);
        
        eastPane.add(rdoNone);
        eastPane.add(rdoAlchemy1);
        eastPane.add(rdoAlchemy2);
        eastPane.add(rdoAlchemy3);
        eastPane.add(rdoAlchemy4);
        eastPane.add(rdoAlchemy5);
        eastPane.add(chk_physician);
        eastPane.add(chk_benefactor);
        eastPane.add(chk_poisoner);
        eastPane.add(chk_seeker_of_shadows);
        
        pack();        
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
                AlchemyPerk = 1.20;
                txt_alchemy_perk.setText("20%");
                break;
            case "Alchemy 2":
                AlchemyPerk = 1.40;
                txt_alchemy_perk.setText("40%");
                break;
            case "Alchemy 3":
                AlchemyPerk = 1.60;
                txt_alchemy_perk.setText("60%");
                break;
            case "Alchemy 4":
                AlchemyPerk = 1.80;
                txt_alchemy_perk.setText("80%");
                break;
            case "Alchemy 5":
                AlchemyPerk = 2.0;
                txt_alchemy_perk.setText("100%");
                break;
            case "Physician Perk":
                if(chk_physician.isSelected()) {
                    PhysicianPerk = 1.25;
                    txt_physician_perk.setText("25%");
                    break;
                } else {
                    PhysicianPerk = 1.0;
                    txt_physician_perk.setText("0%");
                    break;
                }
            case "Benefactor Perk":
                if(chk_benefactor.isSelected()) {
                    BenefactorPerk = 1.25;
                    txt_benefactor_perk.setText("25%");
                    break;
                } else {
                    BenefactorPerk = 1.0;
                    txt_benefactor_perk.setText("0%");
                    break;
                }
            case "Poisoner Perk":
                if(chk_poisoner.isSelected()) {
                    PoisonerPerk = 1.25;
                    txt_poisoner_perk.setText("25%");
                    break;
                } else {
                    PoisonerPerk = 1.0;
                    txt_poisoner_perk.setText("0%");
                    break;
                }
            case "Seeker Of Shadows":
                if(chk_seeker_of_shadows.isSelected()) {
                    SeekerOfShadows = 1.1;
                    txt_seeker_of_shadows.setText("10%");
                    break;
                } else {
                    SeekerOfShadows = 1.0;
                    txt_seeker_of_shadows.setText("0%");
                    break;
                }
            case "Ench Total":
                enchantCalc();
                break;
            case "Effect List":
                String key = effectList.getSelectedItem().toString();
                BaseMag = Integer.parseInt(df.getBaseMag().get(key).toString());
                BaseDur = (Integer.parseInt(df.getBaseDur().get(key).toString()));
                BaseCost = Double.valueOf(df.getBaseCost().get(key).toString());
                txt_base_mag.setText(Integer.toString(BaseMag));
                txt_base_dur.setText(Integer.toString(BaseDur));
                txt_base_gold.setText(Double.toString(BaseCost));
                break;
            case "Potion Calc":
                potionMagCalc();
                potionDurCalc();
                potionCostCalc();
                break;
        }
    }

    private void potionMagCalc() {
        /**
         * Variables needed: 
         *  AlchemyPerk
         *  PhysicianPerk
         *  BenefactorPerk
         *  PoisonerPerk
         *  SeekerOfShadows
         *  EnchantmentTotal
         *  BaseMag
         *  BaseCost
         */
        Double AlchemySkill = Double.valueOf(txt_alchemy_skill.getText());
        Double AlchemySkillFactor = 1 + (fAlchemySkillFactor - 1) * (AlchemySkill /100);
        int step1 = BaseMag * fAlchemyIngredientInitMult;
        Double step2 = step1 * AlchemySkillFactor;
        Double step3 = step2 * EnchantmentTotal;
        Double perks = AlchemyPerk * PhysicianPerk * BenefactorPerk * PoisonerPerk;
        Double step4 = step3 * perks;
        Double step5 = step4 * SeekerOfShadows;
        PotionMag = (int) Math.round(step5);
        txt_calc_mag.setText(Integer.toString(PotionMag));
    }
    
    private void potionDurCalc() {
        
        BaseDur = Integer.parseInt(txt_base_dur.getText());
        Duration = BaseDur;
        int DurationFactor = 1;
        if(BaseDur < 0) Duration = 0;
        Duration = Math.round(Duration * DurationFactor);
        if(Duration == 0) { 
            txt_calc_dur.setText("*");
        } else {
            txt_calc_dur.setText(Integer.toString(Duration));
        }
    }
    
    private void potionCostCalc() {
        int magnitudeFactor = 1;
        Double duration = Double.valueOf(txt_base_dur.getText());
        Double durationFactor = 0.0;
        
        if(PotionMag > 0) magnitudeFactor = PotionMag;
        if(PotionMag == 0) magnitudeFactor = 1;
        if(Duration > 0) durationFactor = duration / 10;
        
        Double magFact = Math.pow(magnitudeFactor, 1.1);
        Double durFact = Math.pow(durationFactor, 1.1);
        Double value = (BaseCost * Math.max(magFact, 1) * Math.max(durFact, 1));
        PotionCost = (int) Math.round(Math.floor(value));
        txt_calc_gold.setText(Integer.toString(PotionCost));
    }

    private void enchantCalc() {
        Double ring = Double.valueOf(txt_ench_ring.getText());
        Double amulet = Double.valueOf(txt_ench_amulet.getText());
        Double headgear = Double.valueOf(txt_ench_headgear.getText());
        Double hands = Double.valueOf(txt_ench_hands.getText());
        Double temp = 1 + ((ring + amulet + headgear + hands)/100);
        System.out.println("Enchantment Totals:");
        System.out.println("    Ring: " + ring);
        System.out.println("  Amulet: " + amulet);
        System.out.println("Headgear: " + headgear);
        System.out.println("   Hands: " + hands);
        System.out.println("   Total: " + temp);
        if(temp.toString().length() < 4) {
            txt_ench_total.setText(Double.toString(temp));
        } else {
            txt_ench_total.setText(Double.toString(temp).substring(0, 4));
        }
        EnchantmentTotal = Double.valueOf(txt_ench_total.getText());
    }

    

}
