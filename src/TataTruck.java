
public class TataTruck implements Truck {
	
	private final Barcode barcode;
	private int weight;
	
	public TataTruck()
	{
		this.barcode = new Barcode();
		this.weight = 0;
	}
	
	public TataTruck(Barcode barcode,int weight)
	{
		this.barcode = new Barcode(barcode);
		this.weight = weight;
	}
	
	public TataTruck(TataTruck t)
	{
		this.barcode = t.barcode;
		this.weight = t.weight;
	}
	
	public Barcode getBarcode()
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
}
