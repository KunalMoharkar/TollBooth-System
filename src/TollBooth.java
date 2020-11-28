
public interface TollBooth {
	
	public int calculateToll(Truck truck);
	public Receipt generateReceipt(Truck truck);
	public void resetBooth();
	public void updateBoothStats(int amount);
	
}
