
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
		Receipt receipt = new Receipt(barcode, amount,"Today","abhi");
		
		return receipt;
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
}

