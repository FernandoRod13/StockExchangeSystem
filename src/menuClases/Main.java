package menuClases;

import java.io.IOException;
import java.util.Stack;

import dataManagment.DMComponent;
import inputOutput.FileOps;
/**
 * This is the main Class of this program. THis is where menu stack is created and the main menu gets called and 
 * before any option is selected the data from the file is read to fill the program with initial data.
 * @author Fernando Rodriguez
 *
 */
public class Main {
/**
 * Main Method
 * @param args
 * @throws IOException File Not Found Exception.
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DMComponent dm = new DMComponent(); 
		Stack<Menu> mStack = dm.getMenuStack(); 
		try {
			FileOps.readFromFile(dm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mStack.push(MainMenu.getMainMenu()); 
		while(!mStack.empty()) {
			Option opt = mStack.peek().activate(); 
			opt.getAction().execute(dm); 
		}
		dm = null;
		mStack = null;
	}

}
