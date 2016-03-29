package objects;

import java.util.ArrayList;
/**
 * THis Class describes the Company object which holds a portfolio of Shares owned by Shareholders, 
 * Shares the Company has, names of the Company and the current Share price of the Company, and the
 * Stock Symbol used for every operation related to the Company.
 * @author Fernando Rodriguez
 *
 */
public class Company {
	private String companyName, stockSymbol;
	private double sharePrice;
	private int shares;
	private int sharesSold;
	private ArrayList<Shares> portfolio;
	/**
	 * This the Company Constructor 
	 * @param companyName Name of the Company to create .
	 * @param stockSymbol Unique Stock Symbol that identifies this Company.
	 * @param shares Initial Amount of Share (cannot be more than 10,000.
	 * @param sharePrice Shares price for this Company.
	 */
	public Company(String companyName, String stockSymbol, int shares, double sharePrice){
		super();
		this.companyName = companyName;
		this.stockSymbol = stockSymbol;
		this.shares = shares;
		this.sharePrice = sharePrice; 
		sharesSold = 0;
		portfolio = new ArrayList<Shares>();
	}

	//Getters and Setters
	/**
	 * Getter: Returns this Company's Name.
	 * @return Company's Name
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * Setter: Assigns a new name for this Company.
	 * @param companyName New Company name.
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * Getter: Returns the Stock Symbol for this Company.
	 * @return This Company's Stock Symbol.
	 */
	public String getStockSymbol() {
		return stockSymbol;
	}
	/**
	 * Setter: Assigns a new Stock Symbol for this Company.
	 * @param stockSymbol Company Stock Symbol.
	 */
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	/**
	 * Getter: Returns the price per Share of this Company.
	 * @return Company Shares price.
	 */
	public double getSharePrice() {
		return sharePrice;
	}
	/**
	 * Setter: Assigns a new Share price for this Company.
	 * @param sharePrice new Share Price.
	 */
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	/**
	 * Getter: Returns the Amount of Shares this Company owns.
	 * @return amount of Share of the Company.
	 */
	public int getShares() {
		return shares;
	}
	/**
	 * Setter: Assigns a new amount of Shares to the Company.
	 * @param shares amount of Shares
	 */
	public void setShares(int shares) {
		this.shares = shares;
	}
	/**
	 * Getter: returns the amount of Shares owned by Shareholders.
	 * @return amount of Shares sold to Shareholders.
	 */
	public int getSharesold(){
		for (Shares share: this.portfolio){
			sharesSold += share.getShareAmount();
		}
		return this.sharesSold;
	}
	
	/**
	 * Getter: returns the ArrayList of Shares of this Company owned by Shareholders.
	 * @return ArrayList of Shares.
	 */
	public ArrayList<Shares> getPortfolio(){
		return this.portfolio;
	}
	
	/**
	 * This method will split the stock for this Company, which means cut the Shares price in half 
	 * and double the amount of hares for this Company and every other Shareholder of this Company.
	 */
	public void splitStock(){
		this.setSharePrice(this.sharePrice/2);
		this.setShares(this.shares*2);
		for (Shares share: this.portfolio){
			share.setShareAmount(share.getShareAmount()*2);
			share.setSharePrice(share.geSharePrice()/2);
		}
	}
	
	/**
	 * This method will output a String version of the data related to this Company Object 
	 * to be displayed in the console.
	 * @return String to version of Company data to Console.
	 */
	public String toString(){
		String str = "Company Name: "+this.companyName+"\nStock Symbol: "+this.stockSymbol+"\nShares: "+this.shares+"\n"
				+ "Price per Share: $"+this.sharePrice;
		return str;
	}
	
	/**
	 * This method converts the Company object into a String line that is used to 
	 * store this Company's data into the reports.txt file.
	 * @return String version of object of type Company to store in file.
	 */
	public String toFile(){
		String str = this.companyName+"|"+this.stockSymbol+"|"+this.shares
				+ "|"+this.sharePrice+"\n";
		return str;
		
	}
	
	/**
	 * This method will create a report of all of the Company's Shares owned by Shareholders 
	 * and then output it as a String.
	 * @return String representing the report for this Company.
	 */
	public String report(){
		String str = this.companyName+" shareholders:\n";
		if(this.portfolio.size()>0){
			for (Shares share: this.portfolio){
				str+=share.getShareOwner().getShName()+" has "+share.getShareAmount()+" shares\n";
			}
		}else{
			str+="No share holders available";
		}
		return str;
	}
	
}
