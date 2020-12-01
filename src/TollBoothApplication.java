/*
 * 
 * @author Kunal moharkar
 * @id BT18CSE018
 *	
 *	this file has Driver code for demonstration
 *
 */

import java.util.*;

public class TollBoothApplication {
	
	public static void main(String[] args)
	{	
		
		//barcodes for  5 test trucks
		Barcode b1_tata = new Barcode("1",5);
		Barcode b1_mahindra = new Barcode("2",4);
		Barcode b2_mahindra = new Barcode("3",6);
		Barcode b2_tata = new Barcode("4",5);
		Barcode b3_tata = new Barcode("5",3);
		
		//5 trucks 2 of mahindra 3 of tata
		Truck t1 = new TataTruck(b1_tata, 12500, 100);
		Truck t2 = new MahindraTruck(b1_mahindra, 10000, 600);
		Truck t3 = new MahindraTruck(b2_mahindra, 20000, 500);
		Truck t4 = new TataTruck(b2_tata, 5000 , 80);
		Truck t5 = new TataTruck(b3_tata, 14000 , 90);
		
		//array of 5 trucks to simulate incoming trucks
		Truck[] incoming_trucks = {t1,t2,t3,t4,t5};
		
		//create a instance of booth as Highwaybooth
		TollBooth booth = new HighwayBooth();
		
		Scanner in = new Scanner(System.in); //scan user actions
		
		for(int i=0;i<5;i++) //run a loop for 5 trucks to simulate their incoming
		{
			
			
			int action;
	
			
			System.out.println("\n---------------------Truck "+(i+1)+" is at tollbooth------------------------------");
			
			System.out.print("Press 1 to scan barcode ctrl+c to quit: ");
			action = in.nextInt();
			
			System.out.println("-------------------Scanning barcode on truck and bill----------------------------");
			incoming_trucks[i].showDetails(); //show truck details
			
			System.out.print("Press 1 to calculate toll ctrl+c to quit: ");
			action = in.nextInt();
			
			System.out.println("-------------------Calculating toll amount----------------------------");
			Receipt rec = booth.generateReceipt(incoming_trucks[i]); //calculate toll
			rec.showReceipt(); //show generate booth stats
			
			System.out.print("Press 1 to display booth details, 2 to collect receipts , ctrl+c to quit: ");
			action = in.nextInt();
			
			if(action == 1)
			{
				System.out.println("-----------------left panel button pressed: displaying details------------");
				booth.showBoothStats();
			}
			else
			{
				booth.collectReceipts();
				System.out.println("----------------------reseting booth-------------------------------");
				booth.showBoothStats();
			}
			
			String d3 = in.nextLine();
			
		}
		
		
		
		
		System.out.println("-------------------output demo for 5th point (date query)--------------------------------");
		System.out.println("----Enter dates between 26-11-2019 to 28-11-2020 to get results (otherwise empty resultset)-----");
		System.out.println("--------------enter dates in format dd-mm-yyyy ex. 01-01-2019-------------------------------");
		
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
	}
}
