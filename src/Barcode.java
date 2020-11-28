
public class Barcode {
	
	private final String truck_id; 
	private final int num_axel;
	
	public Barcode()
	{	
		this.truck_id = "";
		this.num_axel = 0;	
	}
	
	public Barcode(String truck_id, int num_axel)
	{	
		this.truck_id = truck_id;
		this.num_axel = num_axel;
	}
	
	public Barcode(Barcode barcode)
	{	
		this.truck_id = barcode.truck_id;
		this.num_axel = barcode.num_axel;
	}
	
	public int getNumAxel()
	{
		return this.num_axel;
	}
	

	public String getTruckId() {
		return this.truck_id;
	}
}
