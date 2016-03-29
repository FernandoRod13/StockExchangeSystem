package objects;
/**
 * This class Describes the Shares object which is subsequently a property of Company and Shareholder objects
 * @author Fernando Rodriguez
 *
 */
public class Shares {
	private Company originCompany;
	private Shareholder shareOwner;
	private int shareAmount;
	private double price;
	/**
	 * Share object Constructor.
	 * @param originCompany Origin Company object of which the Shares were bought.
	 * @param shareOwner Shareholder object that refers to the owner of the Shares.
	 * @param shareAmount Amount of shares that were bought by the Shareholder.
	 * @param price original price at which the Shares were bought by the Shareholder.
	 */
	public Shares(Company originCompany, Shareholder shareOwner, int shareAmount, double price) {
		super();
		this.originCompany = originCompany;
		this.shareOwner = shareOwner;
		this.shareAmount = shareAmount;
		this.price = price;
	}
	
	//Getters & Setters
	/**
	 * Getter: returns originCompany Origin Company object of which the Shares were bought.
	 * @return Origin Company.
	 */
	public Company getOriginCompany() {
		return originCompany;
	}
	/**
	 * Setter: Changes the Origin Company of which the shares came from.
	 * @param originCompany new Origin Company
	 */
	public void setOriginCompany(Company originCompany) {
		this.originCompany = originCompany;
	}
	/**
	 * Getter: returns Shareholder owner of the Shares.
	 * @return Shareholder
	 */
	public Shareholder getShareOwner() {
		return shareOwner;
	}
	/**
	 * Setter: Changes the Shareholder for this Share.
	 * @param shareOwner Shareholder
	 */
	public void setShareOwner(Shareholder shareOwner) {
		this.shareOwner = shareOwner;
	}
	/**
	 * Getter: returns the amount of Shares bought by the Shareholder.
	 * @return Amount of Shares
	 */
	public int getShareAmount() {
		return shareAmount;
	}
	/**
	 *Setter: Sets the shareAmount of the Share to a new Amount
	 * @param shareAmount Amount of Shares
	 */
	public void setShareAmount(int shareAmount) {
		this.shareAmount = shareAmount;
	}
	/**
	 * Getter: returns the price at which the Shares were bought.
	 * @return price.
	 */
	public double geSharePrice(){
		return this.price;
	}
	/**
	 * Assigns a new price for the Shares.
	 * @param price new price.
	 */
	public void setSharePrice(double price){
		this.price = price;
	}
	
	/**
	 * This method outputs the data of this object as a string.
	 * @return String representation of this object.
	 */
	public String toString(){
		String str ="\nCompany: "+this.originCompany.getCompanyName()+"\nCompany Stock "
				+ "Symbol: "+this.originCompany.getStockSymbol()+""
				+ "\nAmount of Shares: "+this.shareAmount+"\nShare "
						+ "Price: $"+this.originCompany.getSharePrice()+"\n";
		return str;
	}
	/**
	 * This method will convert the object into a line formated to 
	 * be stored in the reports.txt file.
	 * @return String representation of this object.
	 */
	public String toFile(){
		String str = this.originCompany.getStockSymbol()+"|"+this.price+"|"+this.shareAmount+"|"
				+this.shareOwner.getIdnum()+"\n";
		return str;
	}
	

}
