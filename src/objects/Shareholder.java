package objects;

import java.util.ArrayList;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
/**
 * This class describes the Shareholder object. Shareholder has 
 * name, id, portfolio, and active properties.
 * @author Fernando Rodriguez
 *
 */
public class Shareholder {
	private String shName;
	private int idnum;
	private boolean active;
	private ArrayList<Shares> portfolio;
	
	/**
	 * Constructor for Shareholder object.
	 * @param shName The name of the Shareholder.
	 * @param idnum Identification number for the Shareholder
	 * @param active defines if this is an Active Shareholder or not. 
	 */
	public Shareholder(String shName, int idnum, boolean active) {
		super();
		this.shName = shName;
		this.idnum = idnum;
		portfolio = new ArrayList<Shares>();
		this.active = active;
	}
	//Getters and Setters
	/**
	 * Getter: Returns The name of a Shareholder. 
	 * @return Shareholder's Name.
	 */
	public String getShName() {
		return shName;
	}
	/**
	 * Setter: Sets a new name for the Shareholder.
	 * @param shName Shareholder's Name.
	 */
	public void setShName(String shName) {
		this.shName = shName;
	}
	/**
	 * Getter: Returns the id of the Shareholder
	 * @return  id for Shareholder
	 */
	public int getIdnum() {
		return idnum;
	}
	/**
	 * Setter: Assigns a new ID number for this Shareholder.
	 * @param idnum New id number
	 */
	public void setIdnum(int idnum) {
		this.idnum = idnum;
	}
	/**
	 * Changes the activity of this Shareholder to active if inactive and vice versa.
	 */
	public void changeActivity(){
		this.active = !active;
	}
	/**
	 * Returns the list of Shares owned by this Shareholder.
	 * @return ArrayList of Shares.
	 */
	public ArrayList<Shares> getPortfolio(){
		return this.portfolio;
	}
	/**
	 * Getter: returns if user is active or not
	 * @return true if active, false if not.
	 */
	public boolean getActivity(){
		return this.active;
	}
	
	/**
	 * This method is a to String of sorts for the Shareholder object. It will 
	 * return the string representation of the Shareholder's protfolio.
	 * @return String representation of Shareholders portfolio.
	 */
	public String showPortfolio(){
		String str = "Shareholder Name: "+this.shName;
		for (Shares share: this.portfolio){
			str += share.toString();
		}
		
		return str;
	}
	
	/**
	 * This method will convert the object into a line formated to 
	 * be stored in the reports.txt file.
	 * @return String representation of this object.
	 */
	public String toFile(){
		String str = this.shName+"|"+this.idnum+"|"+this.active+"\n";
		return str;
	}
	
	/**
	 * This method is executed when a Shareholder decides to buy Shares from a 
	 * Company.
	 * @param comp Desired Company the Shareholder want to purchase Shares from.
	 * @param amount The Desired amount of Shares to be purchased.
	 * @return true if purchase was successful, false otherwise.
	 */
	public boolean buy(Company comp, int amount){
		IOComponent io = IOComponent.getComponent();
		if(comp.getShares()>=amount){
			Shares share = new Shares(comp, this, amount, comp.getSharePrice());
			this.portfolio.add(share);
			comp.setShares(comp.getShares()-amount);
			comp.getPortfolio().add(share);
			io.output(share.getShareOwner().getIdnum()+" succesfuly purchased "+share.getShareAmount()+" of shares "
					+ "from "+ share.getOriginCompany().getStockSymbol()+". ");
			return true;
		}else{
			io.output(comp.getStockSymbol()+" has insufficient amount of shares for this purchase.");
		}
		return false;
	}
	
	/**
	 * This method is executed when a Shareholder decides to sell Shares from a 
	 * Company.
	 * @param comp Desired Company the Shareholder want to sell Shares from.
	 * @param amount The Desired amount of Shares to be purchased.
	 * @param holder Shareholder who is performing the sell.
	 * @return true if successful, false otherwise.
	 */
	public boolean sell(Company comp, int amount,Shareholder holder){
		int available=0;
		IOComponent io = IOComponent.getComponent();
		ArrayList<Shares> compShareList = new ArrayList<Shares>();
		for(Shares share: this.portfolio){
			if (share.getOriginCompany().equals(comp)){
				available += share.getShareAmount();
				compShareList.add(share);
			}
		}
		
		if (available>=amount){
			int selectionAmount = 0;
			int chosen = 0;
			int selection = 1;
			do{
				io.output("\nChoose Shares to sell:\n");
				for (Shares item: compShareList){
					io.output(selection+") "+item.toString()+"\n");
					selection++;
				}
				selection = 1;
				boolean valid = false;
				do{
					try{
					chosen = Integer.parseInt(io.getInput("\nEnter the Transaction number identified buy \n Example '1' "
							+ "on the top of the transacion of the share\n"))-1;
					if(chosen>=0 && chosen<compShareList.size())
						valid=true;
					}catch(Exception e){
						valid = false;
					}
				}while(!valid);
				
				Shares sharetoremove = compShareList.get(chosen);
				
				int howmany = 0;
				boolean wrong = true;
				do{
					try{
						howmany = Integer.parseInt(io.getInput("Choose a valid amount of Shares of this transaction that "
								+ "you wish to sell"));
						if(howmany>0 &&(selectionAmount+howmany)<=amount){
							wrong = false;
						}if(!((selectionAmount+howmany)<=amount)){
								io.output("The number of shares you entered surpases the original\n desired amount of shares"
										+ "that was chosen to be sold");
								wrong = true;
						}
					}catch(Exception e){
						wrong = true;
					}
				}while(wrong);
				sharetoremove.setShareAmount(sharetoremove.getShareAmount()-howmany);
				if(sharetoremove.getShareAmount()==0){
					compShareList.remove(sharetoremove);
					holder.getPortfolio().remove(sharetoremove);
					comp.getPortfolio().remove(sharetoremove);
				}
				selectionAmount+=howmany;
				sharetoremove.getOriginCompany().setShares(sharetoremove.getOriginCompany().getShares()+selectionAmount);
				io.output(howmany+" shares of "+sharetoremove.getOriginCompany().getStockSymbol()+" have been sold");
				double shareValue = howmany*sharetoremove.getOriginCompany().getSharePrice();
				double initialvalue = howmany*sharetoremove.geSharePrice();
				io.output(" Your net gain is $"+ (shareValue-initialvalue)+"\n");
					
				
				io.output((amount-selectionAmount)+" shares are remaining to complete the transaction."
						+ "\n\nSuccessfuly Completed Transaction");
			
			}while(selectionAmount<amount);
			if (selectionAmount==amount){
				return true;
			}
			
		}
		return false;
	}
	/**
	 * This method will make a summary of all of the Shares purchased by this Shareholder for 
	 * a Company and return the max amount of available Shares in the Shareholder's portfolio.
	 * @param comp The Company of interest
	 * @param holder The shareholder who owns the shares.
	 * @return total amount of shares available to sell for the company of interest
	 */
	public int summary(Shareholder holder, Company comp){
		double price;
		double totalValue = 0.00;
		int amount;
		int totalAmount = 0;;
		for(Shares share: holder.getPortfolio()){
			if (share.getOriginCompany().equals(comp)){
				amount = share.getShareAmount();
				price = share.geSharePrice();
				totalAmount += amount;
				totalValue += price*amount;
			}
		}
		String str = "There are "+totalAmount+" of shares for "+ comp.getStockSymbol()+" with a total price of $"+totalValue+
				"\nThe current stock price is: $"+comp.getSharePrice()+" which means this stock has a\n"
						+ "value of $"+comp.getSharePrice()*totalAmount+"\n";
		IOComponent io = IOComponent.getComponent();
		io.output(str);
		return totalAmount;
	}

}
