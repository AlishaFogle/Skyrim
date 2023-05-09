package skyrim.helpers;

import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class DataFile {

    private final Hashtable<String,Integer> baseMag = new Hashtable<>();
    private final Hashtable<String,Float> baseCost = new Hashtable<>();
    private final Hashtable<String,Integer> baseDur = new Hashtable<>();
    private String[] keys;

    public DataFile(){
        makeBaseMag();
        makeBaseCost();
        makeBaseDur();
        makeKeyArray();
    }
    private void makeBaseDur() {
        baseDur.put("Cure Disease", 0);
        baseDur.put("Cure Poison", 0);
        baseDur.put("Damage Health", 1);
        baseDur.put("Damage Magicka", 1);
        baseDur.put("Damage Magicka Regen", 5);
        baseDur.put("Damage Stamina", 0);
        baseDur.put("Damage Stamina Regen", 5);
        baseDur.put("Fear", 30);
        baseDur.put("Fortify Alteration", 60);
        baseDur.put("Fortify Barter", 30);
        baseDur.put("Fortify Block", 60);
        baseDur.put("Fortify Carry Weight", 300);
        baseDur.put("Fortify Conjuration", 60);
        baseDur.put("Fortify Destruction", 60);
        baseDur.put("Fortify Enchanting", 30);
        baseDur.put("Fortify Health", 60);
        baseDur.put("Fortify Heavy Armor", 60);
        baseDur.put("Fortify Illusion", 60);
        baseDur.put("Fortify Light Armor", 60);
        baseDur.put("Fortify Lockpicking", 30);
        baseDur.put("Fortify Magicka", 60);
        baseDur.put("Fortify Marksman", 60);
        baseDur.put("Fortify One-handed", 60);
        baseDur.put("Fortify Pickpocket", 60);
        baseDur.put("Fortify Restoration", 60);
        baseDur.put("Fortify Smithing", 30);
        baseDur.put("Fortify Sneak", 60);
        baseDur.put("Fortify Stamina", 60);
        baseDur.put("Fortify Two-handed", 60);
        baseDur.put("Frenzy", 10);
        baseDur.put("Invisibility", 4);
        baseDur.put("Lingering Damage Health", 10);
        baseDur.put("Lingering Damage Magicka", 10);
        baseDur.put("Lingering Damage Stamina", 10);
        baseDur.put("Paralysis", 1);
        baseDur.put("Ravage Health", 10);
        baseDur.put("Ravage Magicka", 10);
        baseDur.put("Ravage Stamina", 10);
        baseDur.put("Regenerate Health", 300);
        baseDur.put("Regenerate Magicka", 300);
        baseDur.put("Regenerate Stamina", 300);
        baseDur.put("Resist Fire", 60);
        baseDur.put("Resist Frost", 60);
        baseDur.put("Resist Magic", 60);
        baseDur.put("Resist Poison", 60);
        baseDur.put("Resist Shock", 60);
        baseDur.put("Restore Health", 0);
        baseDur.put("Restore Magicka", 0);
        baseDur.put("Restore Stamina", 0);
        baseDur.put("Slow", 5);
        baseDur.put("Waterbreathing", 5);
        baseDur.put("Weakness to Fire", 30);
        baseDur.put("Weakness to Frost", 30);
        baseDur.put("Weakness to Magic", 30);
        baseDur.put("Weakness to Poison", 30);
        baseDur.put("Weakness to Shock", 30);
    }
    private void makeBaseCost() {
        baseCost.put("Cure Disease", 0.5f);
        baseCost.put("Cure Poison", 0.2f);
        baseCost.put("Damage Health", 3.0f);
        baseCost.put("Damage Magicka", 2.2f);
        baseCost.put("Damage Magicka Regen", 0.5f);
        baseCost.put("Damage Stamina", 1.8f);
        baseCost.put("Damage Stamina Regen", 0.3f);
        baseCost.put("Fear", 5.0f);
        baseCost.put("Fortify Alteration", 0.2f);
        baseCost.put("Fortify Barter", 2.0f);
        baseCost.put("Fortify Block", 0.5f);
        baseCost.put("Fortify Carry Weight", 0.15f);
        baseCost.put("Fortify Conjuration", 0.25f);
        baseCost.put("Fortify Destruction", 0.5f);
        baseCost.put("Fortify Enchanting", 0.6f);
        baseCost.put("Fortify Health", 0.35f);
        baseCost.put("Fortify Heavy Armor", 0.5f);
        baseCost.put("Fortify Illusion", 0.4f);
        baseCost.put("Fortify Light Armor", 0.5f);
        baseCost.put("Fortify Lockpicking", 0.5f);
        baseCost.put("Fortify Magicka", 0.3f);
        baseCost.put("Fortify Marksman", 0.5f);
        baseCost.put("Fortify One-handed", 0.5f);
        baseCost.put("Fortify Pickpocket", 0.5f);
        baseCost.put("Fortify Restoration", 0.5f);
        baseCost.put("Fortify Smithing", 0.75f);
        baseCost.put("Fortify Sneak", 0.5f);
        baseCost.put("Fortify Stamina", 0.3f);
        baseCost.put("Fortify Two-handed", 0.5f);
        baseCost.put("Frenzy", 15.0f);
        baseCost.put("Invisibility", 100.0f);
        baseCost.put("Lingering Damage Health", 12.0f);
        baseCost.put("Lingering Damage Magicka", 10.0f);
        baseCost.put("Lingering Damage Stamina", 1.8f);
        baseCost.put("Paralysis", 500.0f);
        baseCost.put("Ravage Health", 0.4f);
        baseCost.put("Ravage Magicka", 1.0f);
        baseCost.put("Ravage Stamina", 1.6f);
        baseCost.put("Regenerate Health", 0.1f);
        baseCost.put("Regenerate Magicka", 0.1f);
        baseCost.put("Regenerate Stamina", 0.1f);
        baseCost.put("Resist Fire", 0.5f);
        baseCost.put("Resist Frost", 0.5f);
        baseCost.put("Resist Magic", 1.0f);
        baseCost.put("Resist Poison", 0.5f);
        baseCost.put("Resist Shock", 0.5f);
        baseCost.put("Restore Health", 0.5f);
        baseCost.put("Restore Magicka", 0.6f);
        baseCost.put("Restore Stamina", 0.6f);
        baseCost.put("Slow", 1.0f);
        baseCost.put("Waterbreathing", 30f);
        baseCost.put("Weakness to Fire", 0.6f);
        baseCost.put("Weakness to Frost", 0.5f);
        baseCost.put("Weakness to Magic", 1.0f);
        baseCost.put("Weakness to Poison", 1.0f);
        baseCost.put("Weakness to Shock", 0.7f);
    }
    private void makeBaseMag() {
        baseMag.put("An Effect",0);
        baseMag.put("Cure Disease", 5);
        baseMag.put("Cure Poison", 2);
        baseMag.put("Damage Health", 2);
        baseMag.put("Damage Magicka", 3);
        baseMag.put("Damage Magicka Regen", 100);
        baseMag.put("Damage Stamina", 3);
        baseMag.put("Damage Stamina Regen", 100);
        baseMag.put("Fear", 1);
        baseMag.put("Fortify Alteration", 4);
        baseMag.put("Fortify Barter", 1);
        baseMag.put("Fortify Block", 4);
        baseMag.put("Fortify Carry Weight", 4);
        baseMag.put("Fortify Conjuration", 5);
        baseMag.put("Fortify Destruction", 5);
        baseMag.put("Fortify Enchanting", 1);
        baseMag.put("Fortify Health", 4);
        baseMag.put("Fortify Heavy Armor", 2);
        baseMag.put("Fortify Illusion", 4);
        baseMag.put("Fortify Light Armor", 2);
        baseMag.put("Fortify Lockpicking", 2);
        baseMag.put("Fortify Magicka", 4);
        baseMag.put("Fortify Marksman", 4);
        baseMag.put("Fortify One-handed", 4);
        baseMag.put("Fortify Pickpocket", 4);
        baseMag.put("Fortify Restoration", 4);
        baseMag.put("Fortify Smithing", 4);
        baseMag.put("Fortify Sneak", 4);
        baseMag.put("Fortify Stamina", 4);
        baseMag.put("Fortify Two-handed", 4);
        baseMag.put("Frenzy", 1);
        baseMag.put("Invisibility", 0);
        baseMag.put("Lingering Damage Health", 1);
        baseMag.put("Lingering Damage Magicka", 1);
        baseMag.put("Lingering Damage Stamina", 1);
        baseMag.put("Paralysis", 0);
        baseMag.put("Ravage Health", 2);
        baseMag.put("Ravage Magicka", 2);
        baseMag.put("Ravage Stamina", 2);
        baseMag.put("Regenerate Health", 5);
        baseMag.put("Regenerate Magicka", 5);
        baseMag.put("Regenerate Stamina", 5);
        baseMag.put("Resist Fire", 3);
        baseMag.put("Resist Frost", 3);
        baseMag.put("Resist Magic", 1);
        baseMag.put("Resist Poison", 4);
        baseMag.put("Resist Shock", 3);
        baseMag.put("Restore Health", 5);
        baseMag.put("Restore Magicka", 5);
        baseMag.put("Restore Stamina", 5);
        baseMag.put("Slow", 50);
        baseMag.put("Waterbreathing", 0);
        baseMag.put("Weakness to Fire", 3);
        baseMag.put("Weakness to Frost", 3);
        baseMag.put("Weakness to Magic", 2);
        baseMag.put("Weakness to Poison", 2);
        baseMag.put("Weakness to Shock", 3);
    }
    private void makeKeyArray() {
        Vector<String> temp = new Vector<>();
        Enumeration keylist = getBaseMag().keys();
        keys = new String[baseMag.size()];
        int y = getBaseMag().size();
        while(keylist.hasMoreElements()) {
            temp.add(keylist.nextElement().toString());
        }
        temp.sort(Comparator.naturalOrder());
        for(int x = 0; x <= temp.size()-1; x++) {
            keys[x] = temp.elementAt(x);
        }
    }

    public Hashtable getBaseMag(){ return baseMag; }
    public Hashtable getBaseCost(){ return baseCost; }
    public Hashtable getBaseDur(){ return baseDur; }
    public String[] getKeys() { return keys; }
}
