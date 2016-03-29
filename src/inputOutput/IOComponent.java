package inputOutput;

import java.util.Scanner;

/**
 * This class will handle all input and output of the console
 * @author Fernando Rodriguez
 *
 */
public class IOComponent {
	private static final  IOComponent 	COMPONENT = new IOComponent(); 
	private Scanner sc; 
	/**
	 * Constructor
	 */
	private IOComponent() { 
		sc=new Scanner(System.in);
	}
	/**
	 * Getter: returns static object of this class to execute methods for this class.
	 * @return object of this data type
	 */
	public static IOComponent getComponent() { 
		return COMPONENT; 
	}
	/**
	 * This method will output a message to the console and return user input to the console.
	 * @param msg Message to print on the console.
	 * @return User input from the console.
	 */
	public String getInput(String msg) { 
		System.out.println(msg); 
		return sc.nextLine(); 
	}
	/**
	 * This method will only print messages to the console.
	 * @param line Message to be printed in the console.
	 */
	public void output(String line) { 
		System.out.print(line);
	}
}
