package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Company;
/**
 * This class describes the action of the Update Stock Value option in the Administration of Stock's Menu.
 * @author Fernando Rodriguez
 *
 */
public class UpdateStockValueAction implements Action {

	@Override
	/**
	 * This method will update the stock price for a Company.
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		IOComponent io = IOComponent.getComponent();
		String stkSym;
		Company comp;
		do {
			stkSym = io.getInput("Enter Company Stock Symbol to update stock value").toUpperCase();
			comp = dm.findSymbol(stkSym);
			if (comp == null){
				stkSym = io.getInput("Company does not exist. Enter Company Stock Symbol to update stock value").toUpperCase();
				comp = dm.findSymbol(stkSym);
			}
		}while(comp==null);
		String value;
		do {
			value = io.getInput("Enter new stock value for "+comp.getStockSymbol());
		}while(!dm.validateStockPrice(value));
		comp.setSharePrice(Double.parseDouble(value));
		io.output(comp.getStockSymbol()+" new stock price is $"+comp.getSharePrice());
		dm = null;
		io = null;
		stkSym = null;
		comp = null;
		value = null;
	}

}
