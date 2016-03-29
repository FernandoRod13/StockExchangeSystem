package menuClases;
/**
 * This class describes the option object used in each menu to add options for each Menu.
 * @author Fernando Rodriguez
 *
 */
public class Option {
	private String description;
	private Action action;
	public static final Option EXIT = 
			new Option("Exit", new ExitAction()); 
	/**
	 * Constructor
	 * @param description String describing what this option will do.
	 * @param action The action object that will be executed if this option is selected.
	 */
	public Option(String description, Action action) { 
		this.description = description; 
		this.action = action; 
	}
	//Getters and Setters
	/**
	 * Returns the name of the option.
	 * @return Option name.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Returns the action Executed by the selection of this option.
	 * @return Action to be executed.
	 */
	public Action getAction() {
		return action;
	}

}
