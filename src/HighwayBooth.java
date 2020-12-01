/*
 * 
 * @author Kunal moharkar
 * @id BT18CSE018
 *	
 *	this file has class HighwayBooth which implements the standard TollBooth interface
 *
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  


public class HighwayBooth implements TollBooth{
	
	private int num_trucks;              //number of trucks since last collection
	private int total_amount;			 //amount since last collection
	
	
	public HighwayBooth()				//constructor
	{	
		this.num_trucks = 0;
		this.total_amount = 0;
	}
	
	public HighwayBooth(int num_trucks,int total_amount)  //parameterized constructor
	{
		this.num_trucks = num_trucks;
		this.total_amount = total_amount;
	}
	
	public HighwayBooth(HighwayBooth booth)				//copy constructor
	{
		this.num_trucks = booth.num_trucks;
		this.total_amount = booth.total_amount;
	}
	
	public int getNumTrucks()						  //getters
	{
		return this.num_trucks;
	}
	
	public int getTotalAmount()
	{
		return this.total_amount;
	}
	
	public int calculateToll(Truck t)				 //calculates toll using given formula
	{	
		int axel = t.getBarcode().getNumAxel();
		int weight = t.getWeight();
		
		int amount = 5*axel + (weight/1000)*20;
		
		return amount;
	}
	
	public Receipt generateReceipt(Truck t)		   //generates a receipt of toll to be stored in file
	{	
		Barcode barcode = t.getBarcode();			//scan barcode
		int amount = this.calculateToll(t);			//get the toll amount
		this.updateBoothStats(amount);				//update the toll status by adding this amount 
		
		Date d = new Date();						//get the current date
		
		SimpleDateFormat timeformat = new SimpleDateFormat("H:mm:ss");	//24 hr format time
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy"); //date format
		
		String time = timeformat.format(d);			//extract date and time
		String date = dateformat.format(d);
		
		
		Receipt receipt = new Receipt(barcode, amount, date, time);	//generate new receipt
		
		this.registerEntry(receipt);				//register the receipt into the file
		
		return receipt;
	}
	
	public void registerEntry(Receipt receipt)  //make entry to the file 
	{
		 try
		 {	 						//path for output file
		     FileWriter myWriter = new FileWriter("filename.txt",true);
		     myWriter.write("Receipt_id:"+receipt.getReceiptId()+" Truck_id:"+receipt.getTruckId() +" Amount:"+receipt.getAmount() +" Time:"+receipt.getTime() +" Date:"+receipt.getDate()+"\n");
		     myWriter.close();
		     
		 } 
		 catch (IOException e) 
		 {
		     System.out.println("An error occurred.");
		     e.printStackTrace();
		 }
	}
	
	//this function queries the file and returns all entries betwen the 2 input dates
	public ArrayList<Receipt> showBoothEntries(String d1, String d2)
	{
		ArrayList<Receipt> receiptList =  new ArrayList<Receipt>();
		 try 
		 {
			 	//here testfile is used just for demonstration to have a range of date queries(20)
			 	//from 26-11-2019 to 28-11-2020
		      File myFile = new File("testfile.txt");
		      Scanner myReader = new Scanner(myFile);
		      
		      while (myReader.hasNextLine()) 
		      {
		        String data = myReader.nextLine();
		        String[] processedData = data.split(" ", 5); //split on spaces
		        
		        String[] membervalue = {"","","","",""};
		        
		        for(int i=0;i<5;i++)						//extract receipt credentials back
		        {
		        	String processedString = processedData[i];
			        String[] dataString = processedString.split(":", 2); // split on :
			        membervalue[i] = dataString[1];
		        }
		       
		        
		        String currentdate = membervalue[4];   //get entry current date
		        
		        
		        //if current date is between input dates then add to the arraylist
		        if(this.compareDates(d1,currentdate)<=0 && this.compareDates(d2, currentdate)>=0)
		        {
			        
			        Receipt receipt = new Receipt();
			        receipt.setReceiptId(membervalue[0]);
			        receipt.setTruckId(membervalue[1]);
			        receipt.setAmount(Integer.parseInt(membervalue[2]));
			        receipt.setTime(membervalue[3]);
			        receipt.setDate(membervalue[4]);
			        
			        receiptList.add(receipt);
		        
		        }
		        
		         
		      }
		      
		      myReader.close();
		      
		 } 
		 catch (FileNotFoundException e) 
		 {   	
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
		 
		 return receiptList;
	}
	
	//compares 2 input dates returns 1 if d1 occures after d2 and -1 fir vice versa
	//outputs zero for same dates
	public int compareDates(String date1,String date2)
	{	
		 int retval=0;
		 SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
		 Date d1,d2;
		 
		 try 
		 {
			d1 = sdformat.parse(date1);
			d2 = sdformat.parse(date2);
			      
			if(d1.compareTo(d2) > 0)
			{
			    //System.out.println("Date 1 occurs after Date 2");
			    retval = 1;
			} 
			else if(d1.compareTo(d2) < 0) 
			{
			    //System.out.println("Date 1 occurs before Date 2");
			    retval = -1;
			} 
			else
			{
				//System.out.println("Both dates are equal");
				retval = 0;
			}
			
			
			
		 } 
		 catch (ParseException e) 
		 {
			System.out.println("An error occurred.");
			e.printStackTrace();
		 }
		 
		 return retval;
	     
	   
	}
	
	//collects the receipts prints booths data and resets the booth
	public void collectReceipts()
	{	
		System.out.println("*****Collecting Receipts******");
		this.showBoothStats();
		this.resetBooth();    //reset
	}
	
	//update booth with input amount and increment num trucks by 1
	public void updateBoothStats(int amount)
	{
		this.num_trucks++;
		this.total_amount += amount;
	}
	
	//reset 
	public void resetBooth()
	{
		this.num_trucks = 0;
		this.total_amount = 0;
	}
	
	
	//show booth current status
	public void showBoothStats()
	{
		System.out.println("\n****** Booth Stats *******");
		System.out.println("\nTotals since the last collection - Receipts: Rs."+ this.getTotalAmount() +" Trucks: "+this.getNumTrucks());
	
	}
	
	
	
}

