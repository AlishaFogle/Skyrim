package skyrim.helpers;

/**
 * Class: Recipes
 * Package: skyrim.helpers
 * @author Alisha
 * @since 
 * @version
 * 
 */
public class Recipes {
    
    String name;
    Double baseCost;
    Double baseMag;
    Double baseDur;
    Ingredients ingredients = new Ingredients();
    

    /**
     * setName(String name)
     * @param name Recipe name.
     */
    public void setName(String name) { this.name = name; }
    /**
     * getName(String name)
     * @return name Recipe name.
     */
    public String getName() { return name; }

    /**
     * setBaseMag(Double num)
     * @param num Recipe Base Magnitude.
     */
    public void setBaseMag(Double num) { baseMag = num;}

    /**
     * getBaseMag()
     * @return Double baseMag
     */
    public Double getBaseMag() { return baseMag; }

    /**
     * setBaseDur(Double num)
     * @param num Recipe Base Duration.
     */
    public void setBaseDur(Double num) { baseDur = num; }

    /**
     * getBaseDur()
     * @return Double baseDur
     */
    public Double getBaseDur() { return baseDur;}

    /**
     * setBaseCost(Double num)
     * @param num Recipe Base Cost.
     */
    public void setBaseCost(Double num) { baseCost = num; }

    /**
     * getBaseCost()
     * @return Double baseCost
     */
    public Double getBaseCost() { return baseCost;}

    public static class Ingredient {
        
        public Ingredient() {}
	
	private  String name;
	private  boolean PowerFactor;
	private  boolean PFMagnitude;
	private  boolean PFDuration;
	private  boolean PFCost;
	private  Double magMult;
	private  Double durMult;
	private  Double costMult;
	
	public  void setName(String text) { name = text; }
	public  void setPowerFactor(boolean enabled) { PowerFactor = enabled; }
	public  void setPFMagnitude(boolean enabled) { PFMagnitude = enabled; }
	public  void setPFCost(boolean enabled) { PFCost = enabled; }
	public  void setMagMult(Double num) { magMult = num; }
	public  void setDurMult(Double num) { durMult = num; }
	public  void setCostMult(Double num) { costMult = num; }
	
	public  String getName() {return name; }
	public  boolean getPowerFactor() { return PowerFactor; }
	public  boolean getPFMagnitude() { return PFMagnitude; }
        public  boolean getPFDuration() { return PFDuration; }
	public  boolean getPFCost() { return PFCost; }
	public  Double getMagMult() { return magMult; }
	public  Double getDurMult() { return durMult; }
	public  Double getCostMult() { return costMult; }
	
    }

}
