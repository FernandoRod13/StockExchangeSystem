package menuClases;

import java.util.ArrayList;
/**
 * This Class describes the Main Menu
 * @author Fernando Rodriguez
 *
 */
public class MainMenu extends Menu{
	private static final MainMenu MM = new MainMenu(); 
	/**
	 * private Constructor
	 */
	private MainMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Main Menu"; 
		options.add(new Option("Administration of Companies", new AdministrationOfCompaniesActions())); 
		options.add(new Option("Administration of Shareholders", new AdministrationOfShareHoldersActions()));
		options.add(new Option("Administration of Stocks", new AdministrationOfStocksAction()));
		options.add(new Option("Buy/Sell Transactions", new BuyandSellAction()));
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 
	}
	/**
	 * Getter: returns the Menu in question
	 * @return Main Menu
	 */
	public static MainMenu getMainMenu() { 
		return MM; 
	}


}
