
import java.util.ArrayList;

public class TollBoothApplication {
	
	public static void main(String[] args)
	{	
		
		System.out.println("");
		
		Barcode b1 = new Barcode("1",5);
		Truck t1 = new TataTruck(b1, 12500);
		
		TollBooth booth = new HighwayBooth();
		
		
		System.out.println("Receipt Genetration");
		
		Receipt rec = booth.generateReceipt(t1);
		rec.showReceipt();
		
		System.out.println("Update booth status");
		
	
		booth.showBoothStats();
		
		System.out.println("With draw cash");
		
		booth.collectReceipts();
		
		System.out.println("reset booth status");
		
		booth.showBoothStats();
		
		
		System.out.println("output demo for 5th point (date query)");
		
		ArrayList<Receipt> receiptList = booth.showBoothEntries("15-04-2020", "10-10-2020");
		
		for(Receipt receipt : receiptList)
		{
			receipt.showReceipt();
	    }
		
	}
}
