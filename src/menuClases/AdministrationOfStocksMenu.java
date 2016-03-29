package menuClases;

import java.util.ArrayList;
/**
 * This Class describes the Administration of Stock's Menu.
 * @author Fernando Rodriguez
 *
 */
public class AdministrationOfStocksMenu extends Menu{
	private static final AdministrationOfStocksMenu AOSM = new AdministrationOfStocksMenu();
	/**
	 * private menu constructor
	 */
	private AdministrationOfStocksMenu() {
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();
		title = "Administration of Stocks";
		options.add(new Option("Split operation", new SplitStockAction()));
		options.add(new Option("Update stock value", new UpdateStockValueAction()));
		options.add(new Option("Shares report", new ShowReportAction()));
		options.add(Option.EXIT);
		super.InitializeMenu(title, options);
		
	}
	/**
	 * Getter: Returns the Menu in question.
	 * @return Administration of Stock's Menu
	 */
	public static AdministrationOfStocksMenu getAdministrationOfStocksMenu() { 
		return AOSM; 
	}

}
