package menuClases;

import dataManagment.DMComponent;
/**
 * This class describes the action related Administration of Shareholders option from the Main Menu.
 * @author Fernando Rodriguez
 *
 */
public class AdministrationOfShareHoldersActions implements Action {

	@Override
	/**
	 * This method will call the Administration of Shareholder's Menu.
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		dm.getMenuStack().push(AdministrationOfShareHoldersMenu.getAdministrationOfShareHoldersMenu()); 
		dm = null;
	}

}
