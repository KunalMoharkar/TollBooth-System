
public class TollBoothApplication {
	
	public static void main(String[] args)
	{
		Barcode b1 = new Barcode("1",5);
		Truck t1 = new TataTruck(b1, 12500);
		
		TollBooth booth = new HighwayBooth();
		
		System.out.println(booth.calculateToll(t1));
	}
}
