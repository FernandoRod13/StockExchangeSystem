package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Shareholder;
/**
 * This Class describes the Add new Shareholder Option of the Shareholder Administration Menu.
 * @author Fernando Rodriguez
 *
 */
public class AddNewShareholderAction implements Action {

	@Override
	/**
	 * This method when executed will create a new Shareholder object and add it to the list 
	 * or change the activity of an existing inactive Shareholder to active
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		DMComponent dm = (DMComponent) args; 
		String listname = "Shareholder List";
		String name = io.getInput("Enter the Shareholder Name:");
		Shareholder sh;
		if(!dm.exisitingInactiveShareholder(name)){
			sh = new Shareholder(name,dm.generateID(), true);
			io.output("Your id is "+sh.getIdnum());
			dm.addToList(listname, sh);
		}
		listname = null;
		name = null;
		sh = null;
		io = null;
		dm = null;

	}

}
