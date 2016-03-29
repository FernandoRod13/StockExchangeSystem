package menuClases;

import dataManagment.DMComponent;
import inputOutput.IOComponent;
import objects.Company;
/**
 * This class Describes the Add New Company Action of the Administration of Company's Menu.
 * @author Fernando Rodriguez
 *
 */
public class AddNewCompanyAction implements Action{

	@Override
	/**
	 * This action when executed will create a new Company if the Company does not exist in the Company List
	 */
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		DMComponent dm = (DMComponent) args; 
		String listname = "Company List";
		String compName =  io.getInput("Enter the name of the new Company to add to the Company List:");
		boolean exists = true;
		String stkSym = io.getInput("Enter the stock symbol for "+ compName +":").toUpperCase();
		do{
			if(dm.findSymbol(stkSym)!=null)
				stkSym = io.getInput("Stock symbol is already in use please a new stock symbol for "+ compName +":").toUpperCase();
			else 
				exists = false;
		}while (exists);
		boolean valid = false;
		int shareAmount = 0;
		do{
		try{
			shareAmount = Integer.parseInt(io.getInput("Enter the Amount of initial amount of shares for "+compName+":"));
			if(shareAmount>0 && shareAmount<10000){
				valid = true;
			}
			}catch(Exception e){
				valid = false;
			}
		}while(!valid);
		String strprice = io.getInput("Enter the Stock price for "+compName+":");
		Double price = 0.00;
		valid= false; 
		
		do{
				strprice=io.getInput("Invalid price. Enter a valid Stock price for "+compName+":(A valid stock price is"
						+ "greater than 0 and has 2 decimal places. Ex. xxxx.xx)"); 
				if(dm.validateStockPrice(strprice)){
					valid = true;
					price = Double.parseDouble(strprice);
				}else
					valid = false;
			
		}while (!valid);
		
		Company company = new Company(compName, stkSym, shareAmount, price);
		io.output("Successfuly added "+company.getCompanyName()+" to "+listname);
		dm.addToList(listname, company); 
		io = null;
		dm = null;
		strprice  = null;
		listname = null;
		compName = null;
		
	}

}
