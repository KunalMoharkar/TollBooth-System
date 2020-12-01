/*
 * 
 * @author Kunal moharkar
 * @id BT18CSE018
 *	
 *	this file has class MahindraTruck which implements the standard truck interface
 *
 */


public class MahindraTruck implements Truck{      //truck instance implementing Truck interface
	 
	private final Barcode barcode;                //truck has a barocde (barcode is final )
	private int weight;							  // truck weight along with lading (weight can change)
	
	
	private int max_brake_friction; 			  //each truck of different make this
												  //truck uses frictional breaks;
	
	public MahindraTruck()                          //default constuctor
	{
		this.barcode = new Barcode();
		this.weight = 0;
		this.max_brake_friction = 0;
	}
	
	public MahindraTruck(Barcode barcode,int weight,int brake_friction) //parameterized constructor
	{
		this.barcode = new Barcode(barcode);
		this.weight = weight;
		this.max_brake_friction = brake_friction;
	}
	
	public MahindraTruck(MahindraTruck t)			//copy constructor
	{
		this.barcode = t.barcode;
		this.weight = t.weight;
		this.max_brake_friction = t.max_brake_friction;
	}
	
	public Barcode getBarcode()					   // getter setters
	{
		return this.barcode;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public int getMaxBrakeFriction() {
		return this.max_brake_friction;
	}

	public void setMaxBrakeFriction(int max_brake_friction) {
		this.max_brake_friction = max_brake_friction;
	}

	public void showDetails() {
		System.out.println("******Mahindra Truck Details*******");
		System.out.println("Weight: "+ this.getWeight());
		System.out.println("Axels: " + this.barcode.getNumAxel());
		
	}
	
}
