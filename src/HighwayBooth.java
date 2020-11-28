import java.text.SimpleDateFormat;
import java.util.Date;

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
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
		String time = timeformat.format(d);
		String date = dateformat.format(d);
		
		
		Receipt receipt = new Receipt(barcode, amount, date, time);
		
		return receipt;
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

