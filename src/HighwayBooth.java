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
	
	private int num_trucks;
	private int total_amount;
	
	
	public HighwayBooth()
	{
		this.num_trucks = 0;
		this.total_amount = 0;
	}
	
	public HighwayBooth(int num_trucks,int total_amount)
	{
		this.num_trucks = num_trucks;
		this.total_amount = total_amount;
	}
	
	public HighwayBooth(HighwayBooth booth)
	{
		this.num_trucks = booth.num_trucks;
		this.total_amount = booth.total_amount;
	}
	
	public int getNumTrucks()
	{
		return this.num_trucks;
	}
	
	public int getTotalAmount()
	{
		return this.total_amount;
	}
	
	public int calculateToll(Truck t)
	{	
		int axel = t.getBarcode().getNumAxel();
		int weight = t.getWeight();
		
		int amount = 5*axel + (weight/1000)*20;
		
		return amount;
	}
	
	public Receipt generateReceipt(Truck t)
	{	
		Barcode barcode = t.getBarcode();
		int amount = this.calculateToll(t);
		this.updateBoothStats(amount);
		
		Date d = new Date();
		SimpleDateFormat timeformat = new SimpleDateFormat("H:mm:ss");
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String time = timeformat.format(d);
		String date = dateformat.format(d);
		
		
		Receipt receipt = new Receipt(barcode, amount, date, time);
		
		this.registerEntry(receipt);
		
		return receipt;
	}
	
	public void registerEntry(Receipt receipt)
	{
		 try
		 {	 
		     FileWriter myWriter = new FileWriter("C:\\Users\\kumar\\Desktop\\filename.txt",true);
		     myWriter.write("Receipt_id:"+receipt.getReceiptId()+" Truck_id:"+receipt.getTruckId() +" Amount:"+receipt.getAmount() +" Time:"+receipt.getTime() +" Date:"+receipt.getDate()+"\n");
		     myWriter.close();
		     
		 } 
		 catch (IOException e) 
		 {
		     System.out.println("An error occurred.");
		     e.printStackTrace();
		 }
	}
	
	public ArrayList<Receipt> showBoothEntries(String d1, String d2)
	{
		ArrayList<Receipt> receiptList =  new ArrayList<Receipt>();
		 try 
		 {
			 
		      File myFile = new File("C:\\Users\\kumar\\Desktop\\testfile.txt");
		      Scanner myReader = new Scanner(myFile);
		      
		      while (myReader.hasNextLine()) 
		      {
		        String data = myReader.nextLine();
		        String[] processedData = data.split(" ", 5);
		        
		        String[] membervalue = {"","","","",""};
		        
		        for(int i=0;i<5;i++)
		        {
		        	String processedString = processedData[i];
			        String[] dataString = processedString.split(":", 2);
			        membervalue[i] = dataString[1];
		        }
		       
		        
		        String currentdate = membervalue[4];
		        
		        
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
	
	
	public void collectReceipts()
	{	
		System.out.println("\n******Collecting Receipts*******");
		this.showBoothStats();
		this.resetBooth();
	}
	
	public void updateBoothStats(int amount)
	{
		this.num_trucks++;
		this.total_amount += amount;
	}
		
	public void resetBooth()
	{
		this.num_trucks = 0;
		this.total_amount = 0;
	}
	
	public void showBoothStats()
	{
		System.out.println("\n****** Booth Stats *******");
		System.out.println("\nTotals since the last collection - Receipts: Rs."+ this.getTotalAmount() +" Trucks: "+this.getNumTrucks());
	
	}
	
	
	
}

