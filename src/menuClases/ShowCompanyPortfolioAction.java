package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Company;
/**
 * This Class describes the Show Company Portfolio option of the Company Administration Menu.
 * @author Fernando Rodriguez
 *
 */
public class ShowCompanyPortfolioAction implements Action {

	@Override
	/**
	 * This Method will display all Shareholders of a particular Company
	 */
	public void execute(Object args) { 
		DMComponent dm = (DMComponent) args; 
		IOComponent io = IOComponent.getComponent(); 
		String stkSym = io.getInput("Enter the stock symbol of the compnay to show portfolio:").toUpperCase();
		boolean exists= false;
		Company comp;
		do{
			comp = dm.findSymbol(stkSym);
			if (comp !=null)
				exists = true;
			else{
				stkSym = io.getInput("Invalid stock symbol. Enter a valid stock symbol of the compnay to show protfolio".toUpperCase());
				if (comp !=null)
					exists = true;
			}
		}while (!exists);
		io.output(comp.toString());
		comp = null;
		stkSym = null;
		io = null;
		dm = null;

	}

}
