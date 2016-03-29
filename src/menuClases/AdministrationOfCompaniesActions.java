package menuClases;

import dataManagment.DMComponent;
/**
 * This class describes the action related to the Administration of Company's option in the Main Menu.
 * @author Fernando Rodriguez
 *
 */
public class AdministrationOfCompaniesActions implements Action{

	@Override
	/**
	 * This method will call the Administration of Company's Menu
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		dm.getMenuStack().push(AdministrationOfCompaniesMenu.getAdministrationOfCompaniesMenu()); 
		dm = null;
	}

}
