

public class TollBoothApplication {
	
	public static void main(String[] args)
	{
		Barcode b1 = new Barcode("1",5);
		Truck t1 = new TataTruck(b1, 12500);
		
		TollBooth booth = new HighwayBooth();
		
		Receipt rec = booth.generateReceipt(t1);
		
		rec.showReceipt();
		
	}
}
