package inputOutput;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import dataManagment.DMComponent;
/**
 * This class will handle all File Reading and Writing
 * @author Fernando Rodriguez
 *
 */
public class FileOps {	
	/**
	 * Static method that rewrites all data vital for the running this program
	 * in to the reports.txt file (File is overwritten every time program 
	 * terminates successfully).
	 * @param args DM Component for Data Management Class methods access
	 * @throws IOException File not found exception
	 */
	public static void updatesFile(Object args) throws IOException{
		DMComponent dm = (DMComponent) args;
		File textFile = new File("src/reports.txt");
		BufferedWriter out = new BufferedWriter(new FileWriter(textFile));
		try {
			out.write(dm.toFile());
		} finally {
		   out.close();
		}
		
	}
	
	/**
	 *Static method will read reports.txt file and fill the program with all 
	 *the data from the previous run to make data persist across program reruns.
	 * @param args DM Component for Data Management Class methods access
	 * @throws IOException File not found exception
	 */
	public static void readFromFile(Object args) throws IOException{
		DMComponent dm = (DMComponent) args;
		File textFile = new File("src/reports.txt");
		boolean company = true;
		boolean shareholder = false;
		boolean share= false;
		if(textFile.length()!=0){
			try (Scanner scan = new Scanner(textFile)){
				
				String line;
				while (scan.hasNextLine()) {
					line = scan.nextLine();
					if (!line.equals("<<>>") && !line.equals("----")){
						if(company && !shareholder && !share)
							dm.fillCompanyList(line);
						if(!company && !share && shareholder){
							dm.fillShareholderList(line);
						}
						if(!company && share && !shareholder){
							dm.addShareToHolder(line);
						}
						
					}if(line.equals("<<>>")){
						company = !company;
						shareholder = !shareholder;
						
					}if (line.equals("----")){
						shareholder = !shareholder;
						share = !share;
					}
					
				}
	
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}	
	}

}
