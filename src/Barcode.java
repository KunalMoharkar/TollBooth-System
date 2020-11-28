
public class Barcode {
	
	private final int num_axel;
	
	public Barcode()
	{
		this.num_axel = 0;
	}
	
	public Barcode(int num_axel)
	{
		this.num_axel = num_axel;
	}
	
	public Barcode(Barcode barcode)
	{
		this.num_axel = barcode.num_axel;
	}
	
	public int getNumAxel()
	{
		return this.num_axel;
	}
}
