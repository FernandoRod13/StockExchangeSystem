package menuClases;

import java.util.ArrayList;

/**
 * This Class describes the Administration of Company's Menu
 * @author Fernando Rodriguez
 *
 */
public class AdministrationOfCompaniesMenu extends Menu{
	
	private static AdministrationOfCompaniesMenu ACM = new AdministrationOfCompaniesMenu(); 
	/**
	 * private Constructor
	 */
	private AdministrationOfCompaniesMenu(){
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();
		title = "Administration of Companies";
		options.add(new Option("Add a new Company", new AddNewCompanyAction()));
		options.add(new Option("Remove an existing Company", new RemoveCompanyAction()));
		options.add(new Option("Add shares to a Company", new AddSharesToCompanyAction()));
		options.add(new Option("Show Company Portfolio", new ShowCompanyPortfolioAction()));
		options.add(Option.EXIT);
		super.InitializeMenu(title, options);
	}
	/**
	 * Returns the menu in Question
	 * @return Administration of Company's Menu
	 */
	public static AdministrationOfCompaniesMenu getAdministrationOfCompaniesMenu() { 
		return ACM; 
	}

}
