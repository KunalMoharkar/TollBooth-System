
import java.util.ArrayList;

public class TollBoothApplication {
	
	public static void main(String[] args)
	{
		Barcode b1 = new Barcode("1",5);
		Truck t1 = new TataTruck(b1, 12500);
		
		TollBooth booth = new HighwayBooth();
		
		Receipt rec = booth.generateReceipt(t1);
		
		rec.showReceipt();
		
		
		
		ArrayList<Receipt> receiptList = booth.showBoothEntries("15-04-2020", "10-10-2020");
		
		for(Receipt receipt : receiptList)
		{
			receipt.showReceipt();
	    }
		
	}
}
