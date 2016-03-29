package menuClases;

import dataManagment.DMComponent;

/**
 * This Class describes the action executed by the Administration of Stocks option in the Main Menu.
 * @author Fernando Rodriguez
 *
 */
public class AdministrationOfStocksAction implements Action {

	@Override
	/**
	 * This method will Display the Administration of Stock's Menu
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		dm.getMenuStack().push(AdministrationOfStocksMenu.getAdministrationOfStocksMenu()); 
		dm = null;

	}

}
