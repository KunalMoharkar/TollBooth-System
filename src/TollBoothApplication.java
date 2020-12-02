/*
 * 
 * @author Kunal moharkar
 * @id BT18CSE018
 *	
 *	this file has Driver code for demonstration
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TollBoothApplication {
	
	public static void main(String[] args)
	{	
		
		//time refernce initally 0
		int reference_time = 0;
		
		//create a instance of booth as Highwaybooth
		TollBooth booth = new HighwayBooth();
		
		Scanner in = new Scanner(System.in); //scan user actions
		System.out.println("\n=========================WELCOME=========================\n");
		
		try 
		 {
		      File myFile = new File("input.txt"); //read inputs for input file
		      Scanner myReader = new Scanner(myFile);
		      int i = 1;
		      
		      while (myReader.hasNextLine())  //for each truck
		      {
		        String data = myReader.nextLine();
		        String[] processedData = data.split(" ", 6); //split on spaces
		        		
		        String truck_brand = processedData[0];						//get the respective data
		        String truck_id = processedData[1];
		        int axels = Integer.parseInt(processedData[2]);
		        int weight = Integer.parseInt(processedData[3]);
		        int brake_parameter = Integer.parseInt(processedData[4]);
		        int arrival_time = Integer.parseInt(processedData[5]);
		         
		        Barcode br = new Barcode(truck_id, axels);    //create a barcode
		         
		        Truck tr;
		        
		        if(truck_brand.equals("Tata"))					//create a truck based on brand
		        {
		        	tr = new TataTruck(br,weight,brake_parameter);
		        }
		        else
		        {
		        	tr = new MahindraTruck(br,weight,brake_parameter);
		        }
		        
		        int action;
		    	
				
				System.out.println("\nTruck "+i+" is at tollbooth");
				System.out.println("Time is "+arrival_time+" min \n");
				
				System.out.print("Press 1 to scan barcode ctrl+c to quit: ");
				action = in.nextInt();
				
				System.out.println("\nScanning barcode on truck and bill\n");
				tr.showDetails(); //show truck details
				
				System.out.print("Press 1 to calculate toll ctrl+c to quit: ");
				action = in.nextInt();
				
				System.out.println("\nCalculating toll amount\n");
				Receipt rec = booth.generateReceipt(tr); //calculate toll
				rec.showReceipt(); //show generate booth stats
				
				System.out.print("Press 1 to display booth details, 2 to collect receipts , ctrl+c to quit: ");
				action = in.nextInt();
				
				if(action == 1)  //display details
				{
					System.out.println("\nleft panel button pressed: displaying details\n");
					booth.showBoothStats();
				}
				else			//collect receipts
				{
					booth.collectReceipts();
					System.out.println("\nreseting booth\n");
					booth.showBoothStats();
				}
				
				String d3 = in.nextLine();
				
				
				if(arrival_time-reference_time>=10)  //if 10  mins elpased write to file
				{	
					System.out.println("\n10 mins elapsed writing entires to the file now");
					booth.writeBufferEntries();
					reference_time += 10; //increase refernece time
					System.out.println("completed writing - *see filename.txt \n");
				}
				

		        i++;
		         
		      }
		      
		      myReader.close();
		      
		 } 
		 catch (FileNotFoundException e) 
		 {   	
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
		 
	
		System.out.println("\noutput demo for 5th point (date query)");
		System.out.println("Enter dates between 26-11-2019 to 28-11-2020 to get results (otherwise empty resultset)");
		System.out.println("Enter dates in format dd-mm-yyyy ex. 01-01-2019\n");
		
		String d1,d2;
		
		int cond = 1;
		
		while(cond == 1)
		{	
			
		
			System.out.println("input date d1 :");  //scan dates
			d1 = in.nextLine();
			System.out.println("input date d2 : ");
			d2 = in.nextLine();
			
			
			ArrayList<Receipt> receiptList = booth.showBoothEntries(d1,d2);
			
			if(receiptList.size() == 0)
			{
				System.out.println("\nEmpty set");
			}
			else
			{
				for(Receipt receipt : receiptList)
				{
					receipt.showReceipt();
			    }
			}
			
			System.out.println("Press 1 to continue 0 to quit");
			cond = in.nextInt();
			String d3 = in.nextLine();
		}
		
		in.close(); //close scanner
		
		System.out.println("****file logs can be viewed in filename.txt*** date ranges can be verifiled with testfile.txt****");
		System.out.println("\n=========================THANK YOU=========================\n");
	}
}
