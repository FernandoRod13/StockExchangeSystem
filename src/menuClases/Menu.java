package menuClases;

import java.util.ArrayList;

import inputOutput.IOComponent;
/**
 * This Class describes the behavior of Menu objects.
 * @author Fernando Rodriguez
 *
 */
public class Menu {
	private ArrayList<Option> options;
	private String menuString;
	/**
	 * Displays Menu.
	 * @param title Menu Title.
	 * @param options All the options of this menu.
	 */
	protected void InitializeMenu(String title, ArrayList<Option> options) {
		this.options = options; 
		menuString = "\n\n" + title + "\n"; 
		for (int i=0; i<options.size(); i++) { 
			Option opt = options.get(i); 
			menuString += " <" + (i+1) + "> " + opt.getDescription() + "\n"; 
		}
		menuString += "\nEnter your selection: "; 
	}
	/**
	 * Adds an option to a menu.
	 * @param opt option to be added.
	 */
	protected void addOption(Option opt) { 
		options.add(opt); 
	}
	/**
	 * Shows every option related to this menu.
	 */
	private void displayOptions() { 
		IOComponent.getComponent().output(menuString);
	}
	
	/**
	 * Executes the Action related o the user selection of the option in question.
	 * @return Menu option
	 */
	public Option activate() {
		displayOptions();
		int optIndex = getSelectionFromUser(); 
		return options.get(optIndex-1);
	}
	/**
	 * private method that validates the selection of a user.
	 * @return selection of the user.
	 */
	private int getSelectionFromUser() { 
		boolean validSelection = false; 
		int selection = 0 ;   // initialize to comply with compiler
		while (!validSelection) { 
			String input = IOComponent.getComponent().getInput(""); 
			try { 
			selection = Integer.parseInt(input);
			if (selection >=1 && selection <= options.size())
				validSelection = true; 
			} catch(Exception e) { 
				// neglect that a non integer value has been entered
				// just write a message
			}
			if (!validSelection) { 
				IOComponent.getComponent().output("***ERROR: Enter an int value in range 1 to "
						+ options.size() + ".\n"); 
				displayOptions(); 
			}
		}
		return  selection; 
	}
}
