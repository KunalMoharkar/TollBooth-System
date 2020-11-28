import java.util.ArrayList;

public interface TollBooth {
	
	public Receipt generateReceipt(Truck truck);
	public void collectReceipts();
	public void resetBooth();
	public void updateBoothStats(int amount);
	public void showBoothStats();
	public ArrayList<Receipt> showBoothEntries(String d1,String d2);
	
}
