package dataManagment;

import java.util.ArrayList;
import java.util.Stack;

import inputOutput.IOComponent;
import menuClases.Menu;
import objects.Company;
import objects.Shareholder;
import objects.Shares;
/**
 * 
 * @author fernandorodriguez
 *
 */
public class DMComponent {
	private Stack<Menu> mStack;          // stack to manage actions in this system
	private ArrayList<NamedList> lol;    // list of lists of Integers
	/**
	 * Constructor for this class which initiates the list where everything is stored
	 */
	public DMComponent() { 
		lol = new ArrayList<NamedList>(); 
		mStack = new Stack<Menu>();
		lol.add(new NamedList("Company List"));
		lol.add(new NamedList("Shareholder List"));
	}
	/**
	 * Getter: returns the stack of the Menu
	 * @return Menu Stack
	 */
	public Stack<Menu> getMenuStack() { 
		return mStack; 
	}
	/**
	 * private internal class that defines list data type to store each object of type 
	 * Shareholder or Company in the respective list. This list is simply an ArrayList 
	 * that has a name parameter.
	 *
	 * @param <E> This is an element of type Shareholder or Company.
	 */
	private static class NamedList<E> extends ArrayList<E> { 
		private String name;
		/**
		 * Constructor for NamedList 
		 * @param name the name of the List
		 */
		public NamedList(String name) { 
			super(); 
			this.name = name; 
		}
		/**
		 * Getter:
		 * returns the name of the list.
		 * @return name of the list.
		 */
		public  String getName() { 
			return name; 
		}
	}
	
	/**
	 * This method is used to add Shareholders and Companies to their respective NamedList.
	 * @param name Name of the NamedList to add the element.
	 * @param value The object of type Shareholder or Company to add.
	 * @param <E> Data type of object to add (Shareholder or Company).
	 */
	public<E> void addToList(String name, E value) { 
		int index = getIndexForList(name); 
		if (index == -1) 
			IOComponent.getComponent().output("No such list, " + name + ", exists.\n"); 
		else { 
			lol.get(index).add(value); 
		}

	}
	
	/**
	 * Internal private auxiliary method. Gets the index identifying 
	 * a particular list in the system. 
	 * @param name the name of the list to search for,
	 * @return -1 if such list is not in the system. A non-negative 
	 * integer value corresponding to the index of the position
	 * that such list occupies in the system's list of lists...
	 */
	private int getIndexForList(String name) { 
		for (int i=0; i<lol.size(); i++) 
			if (name.equals(lol.get(i).getName())) 
				return i; 
		return -1; 
	}
	
	/**
	 * This method will look for a Company with a Stock Symbol corresponding
	 * to the Stock Symbol inputed as a parameter to this method.
	 * @param sym Stock Symbol of the desired Company
	 * @return Company of corresponding to the Stock Symbol, null if Company doesn't exist.
	 */
	public Company findSymbol( String sym){
		int index = getIndexForList("Company List"); 
		NamedList<Company> list = lol.get(index);	
		for (Company item : list){
			if (item.getStockSymbol().equals(sym)){
				return item;
			}
		}
		return null;
	}
	
	/**
	 * THis method will validate any Share price inputed so that it ensures that the Share price
	 * always has at 2 decimal positions.
	 * @param price String representation of the price of a Share
	 * @return true if the price is a valid entry, false otherwise.
	 */
	public boolean validateStockPrice(String price){
		double parsed = 0.00;
		String strprice = price;
		boolean correct = true;
		do{
			try{
				parsed = Double.parseDouble(strprice);
			}catch(Exception E){
				IOComponent io = IOComponent.getComponent();
				 strprice = io.getInput("Invalid input, enter a valid stock price");
				 correct = false;
			}
		}while(!correct);
			String[] dec = price.split("\\.");
			int size = dec.length;
			if (size==2){
				if(parsed>0|| dec[1].length()==2){
					return true;
				}
			}
		return false;
	}
	
	/**
	 * This method will add an amount of Shares to a Company respectively inputed in the parameters;
	 * @param comp Company to add shares.
	 * @param shares Amount of shares to add.
	 */
	public void addSharesToCompany(Company comp, int shares){
		comp.setShares(comp.getShares()+shares);
	}
	
	/**
	 * This method will remove the Company corresponding to the Stock Symbol 
	 * inputed as a parameter only if this Company has no Shareholders.
	 * @param comp The Company to remove from the list.
	 */
	public void removeCompany(Company comp){
		int index = getIndexForList("Company List");
		if(comp.getPortfolio().size()==0)
			lol.get(index).remove(comp);
			
	}
	
	/**
	 * This method will randomly generate an id for a Shareholder and will also
	 * ensure that the id is not currently in use by any Shareholder active or inactive.
	 * @return Integer representation of the randomly created id for a Shareholder.
	 */
	public int generateID() {
		String idstr = "";
		do{
			int  id =0;
			for (int i=0;i<6;i++){
				id = 0+(int)(Math.random()*9);
				idstr+=id;
			}
		}while (verifyID(idstr)!=null);
		 
		return Integer.parseInt(idstr);
	}
	
	/**
	 * THis method will check if a Shareholder with the inputed id is an existing Shareholder
	 * And returns the object corresponding to such Shareholder that matches the id. If there
	 * is no corresponding shareholder then this method returns null.
	 * @param id String representation of a Shareholder's id.
	 * @return Shareholder 
	 */
	public Shareholder verifyID(String id){
		int index = getIndexForList("Shareholder List");  
		int idnum = Integer.parseInt(id);
		NamedList<Shareholder> list = lol.get(index);
		for (Shareholder sh: list){
			if (sh.getIdnum() == idnum)
				return sh;
		}
		return null;
	}
	
	/**
	 * Sets the Shareholder that matches the id as an inactive Shareholder only if this 
	 * Shareholder doesn't own any Shares of any Company.
	 * @param id The String representation of Shareholder's id.
	 * @return true if successfully set the shareholder as inactive, false otherwise.
	 */
	public boolean removeShareholder(String id){
		Shareholder sh = verifyID(id);
		if(sh!=null && sh.getPortfolio().size()==0 && sh.getActivity()){
			sh.changeActivity();
			return true;
		}if(!sh.getActivity()){
			IOComponent io = IOComponent.getComponent();
			io.output(sh.getIdnum()+" is alreadry an inactive Shareholder.");
		}
		return false;
	}
	
	/**
	 * Converts the data in each NamedList and executes the method of 
	 * each object to output the string representation of the object.
	 * This way the data is persisted across individual program runs
	 * @return The formated string of the data in the program.
	 */
	public String toFile(){
		String str = "";
		NamedList<Company> complist = lol.get(0);
		NamedList<Shareholder> shlist = lol.get(1);
		for (Company element: complist){
			str += element.toFile();
		}
		
		str+="<<>>\n";
		for (Shareholder holder: shlist){
			str += holder.toFile();
		}
		str+="----\n";
		for (Shareholder holder: shlist){
			ArrayList<Shares> portfolio = holder.getPortfolio();
			for (Shares share: portfolio){
				str+=share.toFile();
			}
		}
		
		return str;
	}
	/**
	 * Takes a string from the file where data is stored to be persisted and converts the data
	 * from string to object of type Company and adds it to the Company NamedList.
	 * @param str A line from the reports file.
	 */
	public void fillCompanyList(String str) {
		
		if(!str.equals("<<>>")){
			Company comp;
			String Name = "", Symbol = "";
			int Shares = 0;
			double Price = 0.00;
			String[] format = str.split("\\|");
			Name = format[0];
			Symbol = format[1];
			Shares = Integer.parseInt(format[2]);
			Price = Double.parseDouble(format[3]);
			comp = new Company(Name, Symbol, Shares, Price);
			addToList("Company List", comp);
			comp = null;
			Name = null;
			format = null;
			
		
		}
	}
	/**
	 * Takes a string from the file where data is stored to be persisted and converts the data
	 * from string to object of type Shareholder and adds it to the Shareholder NamedList.
	 * @param str A line from the reports file
	 */
	public void fillShareholderList(String str){
		if(!str.equals("<<>>") && !str.equals("----")){
			Shareholder holder;
			String Name = "";
			int id=0;
			boolean active;
			String[] format = str.split("\\|");
			Name = format[0];
			id = Integer.parseInt(format[1]);
			active = Boolean.parseBoolean(format[2]);
			holder = new Shareholder(Name,id,active);
			addToList("Shareholder List",holder);
			Name = null;
			holder = null;
		}
	}
	/**
	 * Takes a string from the file where data is stored to be persisted and converts the data
	 * from string to object of type share and adds it to respective Shareholder and Company portfolio.
	 * @param str A line from the reports file
	 */
	public void addShareToHolder(String str){
		if(!str.equals("<<>>") && !str.equals("----")){
			Shares share;
			Company comp;
			Shareholder holder;
			double price;
			int amount;
			String[] format = str.split("\\|");
			comp = findSymbol(format[0]);
			price = Double.parseDouble(format[1]);
			amount = Integer.parseInt(format[2]);
			holder = verifyID(format[3]);
			share = new Shares(comp,holder,amount,price);
			holder.getPortfolio().add(share);
			comp.getPortfolio().add(share);
			comp = null;
			holder = null; 
			share = null;
			
		}
		
	}
	/**
	 * This method checks if there is an inactive user with the name entered and if there is
	 * it asks you if you want to change the activity of this user to active instead of creating a new user
	 * @param name String name of the user to verify
	 * @return true if the user exists and has been changed from inactive to active, returns false otherwise.
	 */
	public boolean exisitingInactiveShareholder(String name){
		int index = getIndexForList("Shareholder List"); 
		if (index == -1) 
			IOComponent.getComponent().output("No such list, Shareholder List, exists.\n"); 
		else { 
			NamedList<Shareholder> list = lol.get(index);
			for(Shareholder holder:list ){
				if (holder.getShName().equals(name) && !holder.getActivity()){
					IOComponent io = IOComponent.getComponent(); 
					String yesNo;
					boolean valid = false;
					do{
						try{
							yesNo = io.getInput(holder.getShName()+"is an existing shareholder but is an inactive shareholder,"
								+ "would you like to make him/her an active shareholder?");
							if(yesNo.toUpperCase().equals("YES")||yesNo.toUpperCase().equals("NO"))
								valid = true;
						}catch(Exception e){
							yesNo = io.getInput("Invalid input"+holder.getShName()+"is an existing shareholder but is an inactive shareholder,"
									+ "would you like to make him/her an active shareholder?");
						}
					}while(!valid);
					if(yesNo.equals("Yes")){
						holder.changeActivity();
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
}
