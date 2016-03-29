package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Shareholder;
/**
 * This Class describes the Show Shareholder Portfolio option in the Administration of Shareholder's Menu
 * @author Fernando Rodriguez
 *
 */
public class ShowShareholderPortfolioAction implements Action {

	@Override
	/**
	 * This method will show the portfolio of an Active Shareholder. The portfolio includes every Share
	 * he / she owns.
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		IOComponent io = IOComponent.getComponent();
		Shareholder sh;
		String id;
		do {
			id = io.getInput("Enter the id of an existing Shareholder to show his / her portfolio");
			sh = dm.verifyID(id);
		}while(sh==null);
		if(sh.getActivity())
			io.output(sh.showPortfolio());
		else
			io.output(sh.getIdnum()+" is inactive");
		dm = null;
		io = null;
		id = null;
		sh = null;
	}

}
