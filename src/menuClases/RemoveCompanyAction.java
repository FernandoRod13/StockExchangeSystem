package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Company;
/**
 * This class describes the Remove Company Option in the Administration of Company's Menu
 * @author Fernando Rodriguez
 *
 */
public class RemoveCompanyAction implements Action {

	@Override
	/**
	 * This method when executed will remove a Company object from the Company list if the company does 
	 * not have any Shareholders.
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		DMComponent dm = (DMComponent) args; 
		Company comp;
		String stkSym = io.getInput("Enter the stock symbol of the compnay to Remove:").toUpperCase();
		boolean exists= false;
		do{
			comp = dm.findSymbol(stkSym);
			if (comp!=null){
				exists = true;
			}else{
				stkSym = io.getInput("Invalid stock symbol. Enter a valid stock symbol of the compnay to Remove:").toUpperCase();
			}
		}while (!exists);
		io.output(stkSym+" has been remove from the Company List");
		dm.removeCompany(comp);

	}

}
