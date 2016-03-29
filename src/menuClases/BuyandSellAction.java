package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Company;
import objects.Shareholder;
/**
 * This Class describes the action for the buy or sell option form the Main Menu
 * @author Fernando Rodriguez
 *
 */
public class BuyandSellAction implements Action {

	@Override
	/**
	 * This method will ask the user for data related to purchases he want to make or has made 
	 * and then will execute the desired operation (Buy or Sell).
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		IOComponent io = IOComponent.getComponent();
		String id;
		Shareholder holder;
		do {
			try{
				id = io.getInput("Enter the id of the share holder who will buy/sell stocks:");
				holder = dm.verifyID(id);
			}catch(Exception e){
				holder = null;
			}
		}while(holder==null);
		Company comp;
		String stkSym = io.getInput("Enter the stock symbol of the compnay of interest:").toUpperCase();
		do {
			comp = dm.findSymbol(stkSym);
			if (comp == null){
				stkSym = io.getInput("Company does not exist. Enter the stock symbol of the compnay of interest:").toUpperCase();
			}
		}while(comp==null);
		
		boolean valid = false;
		String buySell;
		do {
			buySell = io.getInput("Would you like to buy or sell? (Enter 'buy' or 'sell')");
			if (buySell.toUpperCase().equals("BUY")||buySell.toUpperCase().equals("SELL"))
				valid = true;
			
		}while(!valid);
		int amount = 0;
		boolean correct = false;
		int maxAmount = 0;
		if(buySell.toUpperCase().equals("SELL")){
			maxAmount = holder.summary(holder, comp);
		}
		do{
			try{
				amount = Integer.parseInt(io.getInput("Enter a valid  the amount of shares you wish to buy or sell:"));
			if (amount>0){
				correct = true;
			}
			}catch(Exception e){
				correct = false;
			}
			
		}while(!correct);
		
		if(buySell.toUpperCase().equals("BUY"))
			holder.buy(comp, amount);
		if(buySell.toUpperCase().equals("SELL") && amount<=maxAmount){
			String yesNo;
			correct = false;
			do{
				yesNo = io.getInput("Would you like to continue? ('Yes' or 'No')");
				if(yesNo.toUpperCase().equals("YES") ||yesNo.toUpperCase().equals("NO"))
					correct = true;
			}while(!correct);
			if(yesNo.toUpperCase().equals("YES"))
				holder.sell(comp, amount, holder);
			else
				io.output("Transaction Canceled");
		}
		dm = null;
		io = null;
		comp = null;
		holder = null;
		id = null;
		buySell = null;
		
	}

}
