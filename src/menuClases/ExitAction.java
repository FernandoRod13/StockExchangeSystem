package menuClases;

import java.io.IOException;

import dataManagment.DMComponent;
import inputOutput.FileOps;
/**
 * THis Class describes the Exit Action displayed in every menu.
 * @author Fernando Rodriguez
 *
 */
public class ExitAction implements Action {

	@Override
	/**
	 * This action will either remove the Menu that is being displayed and, bring up the one before it
	 * or will terminate the execution of the program if the stack is empty and thus print all data into
	 * the reprots.txt file.
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		dm.getMenuStack().pop();
		if (dm.getMenuStack().isEmpty()){
			
			try {
				FileOps.updatesFile(dm);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
