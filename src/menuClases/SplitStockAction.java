package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Company;
/**
 * This class describes the action of the Split Stock option in the Administration of Stocks Menu.
 * @author Fernando Rodriguez
 *
 */
public class SplitStockAction implements Action {

	@Override
	/**
	 * This method when executed will split the Shares of a Company and all of its Shareholders.
	 * Which means the Shares Price will be cut in half and the amount of Shares doubled.
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		IOComponent io = IOComponent.getComponent();
		String stkSym;
		Company comp;
		do{
			stkSym = io.getInput("Enter the stock symbol of an existing company to split it").toUpperCase();
			comp = dm.findSymbol(stkSym);
			if (comp == null){
				stkSym = io.getInput("Company does not exist. Enter the stock symbol of an existing company to split it").toUpperCase();
				comp = dm.findSymbol(stkSym);
			}
		}while(comp == null);
		comp.splitStock();
		io.output(comp.toString());
		io = null;
		dm = null;
		stkSym = null;
		comp = null;
		
	}

}
