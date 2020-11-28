

public class Receipt {
	
	private String receipt_id;
	private String truck_id;
	private int amount;
	private String date;
	private String time;
	
	public Receipt()
	{	
		this.receipt_id="";
		this.truck_id = "";
		this.amount = 0;
		this.date = "";
	    this.time = "";
	}
	
	public Receipt(Barcode barcode,int amount,String date,String time)
	{	
		this.truck_id = barcode.getTruckId();
		this.receipt_id = "REC" + this.truck_id;
		this.amount = amount;
		this.date = date;
	    this.time = time;
		
	}
	
	public Receipt(Receipt receipt)
	{	
		this.receipt_id = receipt.receipt_id;
		this.truck_id = receipt.truck_id;
		this.amount = receipt.amount;
		this.date = receipt.date;
	    this.time = receipt.time;
	
	}
	

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
	
	public void showReceipt()
	{
		System.out.println("\n******************************Receipt Details*************************");
		System.out.println("\nReceipt id: "+this.getReceiptId());
		System.out.println("\nTruck id: "+this.getTruckId());
		System.out.println("\nAmount: "+this.getAmount());
		System.out.println("\nDate: "+this.getDate());
		System.out.println("\nTime: "+this.getTime());
		System.out.println("\n*******************************************************************");
	}
	
}
