/*
 * 
 * @author Kunal moharkar
 * @id BT18CSE018
 *	
 *	this file has class Receipt which is used by the TollBooth (generate receipt and make entry to file)
 *
 */

public class Receipt {
	
	private String receipt_id;  //data members
	private String truck_id;
	private int amount;
	private String date;
	private String time;
	
	public Receipt()			//constructor
	{	
		this.receipt_id="";
		this.truck_id = "";
		this.amount = 0;
		this.date = "";
	    this.time = "";
	}
	
	public Receipt(Barcode barcode,int amount,String date,String time)	//parameterized constructor
	{	
		this.truck_id = barcode.getTruckId();
		this.receipt_id = "REC" + this.truck_id; //unique id as truck id is unique
		this.amount = amount;
		this.date = date;
	    this.time = time;
		
	}
	
	public Receipt(Receipt receipt)			//copy constructor
	{	
		this.receipt_id = receipt.receipt_id;
		this.truck_id = receipt.truck_id;
		this.amount = receipt.amount;
		this.date = receipt.date;
	    this.time = receipt.time;
	
	}
	
											//getters and setters
	public String getReceiptId() {
		return receipt_id;
	}

	public void setReceiptId(String receipt_id) {
		this.receipt_id = receipt_id;
	}

	public String getTruckId() {
		return truck_id;
	}

	public void setTruckId(String truck_id) {
		this.truck_id = truck_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public void showReceipt()			//print receipt
	{
		System.out.println("*****Receipt Details******");
		System.out.println("Receipt id: "+this.getReceiptId());
		System.out.println("Truck id: "+this.getTruckId());
		System.out.println("Amount: "+this.getAmount());
		System.out.println("Date: "+this.getDate());
		System.out.println("Time: "+this.getTime());
		
	}
	
}
