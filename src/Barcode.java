/*
 * 
 * @author Kunal moharkar
 * @id BT18CSE018
 *	
 *	this file has class Barcode which is used by the truck (axel count)
 *
 */
public class Barcode {
	
	private final String truck_id;  //id of truck               
	private final int num_axel;		//num of axels in truck
									//both fields are constant
	
	public Barcode()				//constuctor
	{	
		this.truck_id = "";
		this.num_axel = 0;	
	}
	
	public Barcode(String truck_id, int num_axel)  //parameterized constructor
	{	
		this.truck_id = truck_id;
		this.num_axel = num_axel;
	}
	
	public Barcode(Barcode barcode)				//copy constructor
	{	
		this.truck_id = barcode.truck_id;
		this.num_axel = barcode.num_axel;
	}
	
	public int getNumAxel()					//getters
	{
		return this.num_axel;
	}
	

	public String getTruckId() {
		return this.truck_id;
	}
}
