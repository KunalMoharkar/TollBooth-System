/*
 * 
 * @author Kunal moharkar
 * @id BT18CSE018
 *	
 *	this file has class TataTruck which implements the standard truck interface
 *
 */
public class TataTruck implements Truck {
	
	private final Barcode barcode;				//truck has a fixed barcode
	private int weight;
	private int max_break_pressure;				//each truck has different make , this uses pressure brakes	
	
	public TataTruck()							//constructor
	{
		this.barcode = new Barcode();
		this.weight = 0;
		this.max_break_pressure = 0;
	}
	
	public TataTruck(Barcode barcode,int weight,int break_pressure)	//parameterized constructor
	{
		this.barcode = new Barcode(barcode);
		this.weight = weight;
		this.max_break_pressure = break_pressure;
	}
	
	public TataTruck(TataTruck t)									//copy constructor
	{
		this.barcode = t.barcode;
		this.weight = t.weight;
		this.max_break_pressure = t.max_break_pressure;
	}
	
	public Barcode getBarcode()									//getter setters
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

	public int getMaxBreakPressure() {
		return this.max_break_pressure;
	}

	public void setMaxBreakPressure(int max_break_pressure) {
		this.max_break_pressure = max_break_pressure;
	}
	
	public void showDetails() {
		System.out.println("******Tata Truck Details*******");
		System.out.println("Weight: "+ this.getWeight());
		System.out.println("Axels: " + this.barcode.getNumAxel());
		
	}
	
	
}
