package menuClases;

import java.util.ArrayList;
/**
 * This Class Describes the Administration of Shareholder's Menu.
 * @author Fernando Rodriguez
 *
 */
public class AdministrationOfShareHoldersMenu extends Menu{
	private static AdministrationOfShareHoldersMenu ASHM = new AdministrationOfShareHoldersMenu(); 
	/**
	 * Private Menu Constructor 
	 */
	private AdministrationOfShareHoldersMenu(){
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();
		title = "Administration of Shareholders";
		options.add(new Option("Add a new shareholder", new AddNewShareholderAction()));
		options.add(new Option("Remove an existing shareholder", new RemoveShareholderAction()));
		options.add(new Option("Show portfolio for a particular shareholder", new ShowShareholderPortfolioAction()));
		options.add(Option.EXIT);
		super.InitializeMenu(title, options);
	}
	/**
	 * This method will Call the menu in question
	 * @return Administration of Shareholders Menu
	 */
	public static AdministrationOfShareHoldersMenu getAdministrationOfShareHoldersMenu() { 
		return ASHM; 
	}

}
