package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Company;

/**
 * This class describes the action of the Show Report option in the Administration of Company's Menu.
 * @author Fernando Rodriguez
 *
 */
public class ShowReportAction implements Action {

	@Override
	/**
	 * This method when executed will display the report of a Company, which includes its data and 
	 * all of its shareholders.
	 */
	public void execute(Object args) {
		DMComponent dm = (DMComponent) args; 
		IOComponent io = IOComponent.getComponent();
		String stkSym;
		Company comp;
		do{
			stkSym = io.getInput("Enter the stock symbol of an existing company to Show Report").toUpperCase();
			comp = dm.findSymbol(stkSym);
			if(comp == null){
				stkSym = io.getInput("Company does not exists. Enter the stock symbol of an existing company to Show Report").toUpperCase();
				comp = dm.findSymbol(stkSym);
			}
		}while(comp == null);
		io.output(comp.report());
		dm = null;
		io = null;
		stkSym = null;
		comp = null;
	}

}
