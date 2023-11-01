package app;
/**
 * This class extends the Salable Objects Class
 * @author Elayne Medina
 * @version 1
 * August 21, 2022
 *
 */
public class Weapon extends SalableObject{
/**
 * This constructs a weapon item
 * @param name - of the weapon item
 * @param discription - describes the weapon item 
 * @param price -  cost of the weapon item 
 * @param quantity - amount of the weapon item in stock
 */
	public Weapon(String name, String discription, double price, int quantity) {
		super(name, discription, price, quantity);
		
	}
/**
 * This method compares weapons and other Salable objects by their name
 * and sets them in alphabetical order
 * @param other - a weapon object being compared
 * @return int - positive, 0, or negative
 */
	public int compareTo(Weapon other) {  // new week 3
		String w = this.getName().toLowerCase();       //create strings to hold 
		String o = other.getName().toLowerCase();     //create strings to hold
		
		return w.compareTo(o);       // returns value 
	}
	
}
