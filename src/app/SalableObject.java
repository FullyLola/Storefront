
package app;
/**
 * This class creates Salable Objects and holds methods pertaining to the objects
 * @author Elayne Medina
 *@version 2
 *August 21, 2022
 */
public class SalableObject implements Comparable<SalableObject>  {

	private String name;
	private String discription;
	private double price;
	private int quantity;
	/**
	 * This class constructs the Salable Objects
	 * @param name - of the specific object
	 * @param discription - description of object
	 * @param price - cost of object
	 * @param quantity - amount of object in stock
	 */
	public SalableObject(String name, String discription, double price, int quantity)
	{
		this.name = name;
		this.discription = discription;
		this.price = price;
		this.quantity = quantity;
	}
	
	public SalableObject() {
		
	}
	/**
	 * Sorts objects alphabetically
	 * @param other - compares the object to the object in the parameter
	 * This method will be used in the future
	 */
	public int compareTo(SalableObject other) {   // changed from comparing by price to comparing by alphabetical order
		String w = this.getName().toLowerCase();       //create strings to hold 
		String o = other.getName().toLowerCase();     //create strings to hold
		
		return w.compareTo(o);       // returns value 
		
	}
/**
 * Returns the name of the object
 * @return name of object
 */
	public String getName() {
		return name;
	}
/**
 * sets the name of the object to the parameter
 * @param name of the object
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * returns the description of the object
 * @return - description of object
 */
	public String getDiscription() {
		return discription;
	}
/**
 * sets the description of the object to the parameter
 * @param discription of the object
 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}
/**
 * returns the price of the object
 * @return price of object
 */
	public double getPrice() {
		return price;
	}
/**
 * sets the price of the object to the parameter
 * @param price returns the price
 */
	public void setPrice(double price) {
		this.price = price;
	}
/**
 * returns the quantity of the object in stock
 * @return the amount in stock
 */
	public int getQuantity() {
		return quantity;
	}
/**
 * sets the quantity of the object to the parameter
 * @param quantity sets the stock quantity
 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
/**
 * Increases the quantity of the object by 1
 * will be used more in later versions
 */
	public void incrementQuant() {
		quantity++;
	}
/**
 * Decreases the quantity of the object by 1
 * 	will be used more in the future
 */
	public void decrementQuant() {
		quantity--;
/**
 * This prints a string will all of the object's available information and current states		
 */
	}
	public String toString() {
		return "Product name: " + name + "\nDiscription: " + discription + "\nPrice: " + price + "\nQuantity in stock: " + quantity;
	}

}