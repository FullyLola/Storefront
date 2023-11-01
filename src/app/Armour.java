
package app;
/**
 * This class extends the Salable Objects Class
 * @author Elayne Medina
 * @version 1
 * August 21, 2022
 *
 */
public class Armour extends SalableObject{
/**
 * This constructs an armour object 
 * @param name - name of the armour
 * @param discription - describes the armour
 * @param price - cost of the armour
 * @param quantity - amount in stock of the armour
 */
	public Armour(String name, String discription, double price, int quantity) {
		super(name, discription, price, quantity);
		
	}

}
