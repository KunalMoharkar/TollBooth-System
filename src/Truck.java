/*
 * 
 * @author Kunal moharkar
 * @id BT18CSE018
 *	
 *	this file has interface Truck which is implemented by the TataTruck and MahindraTruck
 *
 */
public interface Truck {
	
	public Barcode getBarcode(); //provide barcode to booth for scanning
	public int getWeight();		//provide the weight through lading bill
	public void showDetails();	//prints truck details
}
