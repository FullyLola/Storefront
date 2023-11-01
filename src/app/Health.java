package app;
/**
 * This class extends the Salable Objects Class
 * @author Elayne Medina
 * @version 1
 * August 21, 2022
 *
 */
public class Health extends SalableObject{
/**
 * This method constructs a health object
 * @param name - names the health item
 * @param discription - describes the health item
 * @param price - cost of health item
 * @param quantity - amount in stock
 */
	public Health(String name, String discription, double price, int quantity) {
		super(name, discription, price, quantity);
		
	}

}
