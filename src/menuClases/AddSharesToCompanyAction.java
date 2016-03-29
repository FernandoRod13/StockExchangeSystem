package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Company;
/**
 * This Class describes the Add Shares to Company of the Administration of Stocks Menu 
 * @author fernandorodriguez
 *
 */
public class AddSharesToCompanyAction implements Action {

	@Override
	/**
	 * This Action when executed will add the desired amount of Shares to a Company of interest
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		DMComponent dm = (DMComponent) args; 
		boolean exists= false;
		Company comp;
		String stkSym;
		do{
			stkSym = io.getInput("Enter a valid stock symbol of the compnay to add shares:").toUpperCase();
			comp = dm.findSymbol(stkSym);
			if (comp!=null)
				exists = true;
			else
				stkSym = io.getInput("Invalid stock symbol.Enter a valid stock symbol of the compnay to add shares:").toUpperCase();
		}while(!exists);
		boolean valid = false;
		int shares = 0;
		do{
			try{
				shares = Integer.parseInt(io.getInput("Input the amount of shares to add"));
				if (shares>0)
					valid = true;
			}catch(Exception e){
				valid = false;
			}
		}while(!valid);
		io.output(shares+" shares have been added to "+stkSym);
		dm.addSharesToCompany(comp, shares);
		dm = null;
		io = null;
		comp = null;
		stkSym = null;
		
	}

}
