/*
 * 
 * @author Kunal moharkar
 * @id BT18CSE018
 *	
 *	this file has interface TollBooth which is implemented by the HighwayTollBooth
 *
 */
import java.util.ArrayList;

public interface TollBooth {
	
	public Receipt generateReceipt(Truck truck);			//calculate toll and make receipt
	public void collectReceipts();							//collet receipt
	public void resetBooth();								//reset booth
	public void updateBoothStats(int amount);				//update booth
	public void showBoothStats();							//show booth values
	public ArrayList<Receipt> showBoothEntries(String d1,String d2);	//query booth file on date ranges
	
}
