package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
/**
 * This Class describes the Remove Shareholder Option from the Administration of Shareholders Menu.
 * @author fernandorodriguez
 *
 */
public class RemoveShareholderAction implements Action {

	@Override
	/**
	 * This method will change an existing Shareholder to Inactive if the Shareholder in
	 * question is an Active Shareholder.
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		DMComponent dm = (DMComponent) args; 
		String id;
		boolean removed = false;
		do{
			id = io.getInput("Enter the id of an existing shareholder to remove");
			removed = dm.removeShareholder(id);
		}while(!removed);
		io.output(id+" is now an inactive shareholder");
		io = null;
		id = null;
		dm = null;
	}

}
