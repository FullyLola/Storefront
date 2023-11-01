package app;

import java.util.ArrayList;
/**
 * This class creates an arraylist of objects in a user's shopping cart and holds methods 
 * that help execute those actions
 * @author Elayne Medina
 * @version 5 updated 9/11/22
 *August 21, 2022
 */
public class ShoppingCart {
	ArrayList<SalableObject> cart = new ArrayList();
	
	
	public ShoppingCart() {
		InventoryManager inventory = new InventoryManager();
		for(SalableObject item : inventory.products) {
			item.setQuantity(0);
			cart.add(item);
		}
	}

/**
 * This methods adds a Salable Object to the ArrayList cart	
 * @param a is the salable object being added
 */
	public void addToCart(SalableObject a) {    // increments item quantity
		for(SalableObject item : cart) {
			if (item.getName().equals(a.getName())) {
				item.incrementQuant();
				return;
			}
		}
		System.out.println("Error, this item is not found in the cart");
	}
/**
 * This method returns the number of items in the arraylist cart	
 * @return the amount of salable objects in the arraylist
 */
	public int numItems() {
		int sum = 0;
		for(SalableObject item : cart) {
		sum+= item.getQuantity();
	}
	return sum;
	}
/**
 * This method removes a specific item from the cart	
 * @param index is the index of the object in the arraylist
 */
	public void removeFromCart(int index) {
		if(cart.get(index).getQuantity() > 0) {
			cart.get(index).decrementQuant();
		}
		else {
			System.out.println("Error, this item is not in your cart");
		}	
	}
/**
 * This clears the shopping cart arraylist	
 */
	public void removeAll() {
		for(SalableObject item : cart) {
			item.setQuantity(0);
		}
	}
/**
 * This method returns the name of the Salable Objects in the array list and their indexes
 * returns ans - a string of object names and their indexes	
 */
	public String toString() {
		 String ans = "";
		  for(int i = 0; i < cart.size(); i++){
			  if(cart.get(i).getQuantity() > 0) {       // modified 
				  ans += i + ": " + cart.get(i).getName() + " Quantity in cart: " + cart.get(i).getQuantity() + " \n";
			  }
		  }
		  return ans;
	}
/**
 * This method changes the quantity of an object based on if the object move from the inventory to the cart or vis versa	
 * @param to - the array list that the "object"/quantity is being moved to
 * @param from - the array list that the "object"/quantity is moving from
 * @param object - the item being purchase or cancelled
 */
	public static void moveObject(ArrayList<SalableObject> to, ArrayList<SalableObject> from, SalableObject object) {
	 for (SalableObject item : from) {
		 if(item.getName().equals(object.getName())) {
			 item.decrementQuant();
		 }
	 }
	 for (SalableObject item : to) {
		 if(item.getName().equals(object.getName())) {
			 item.incrementQuant();
		 }
	 }
	}
/**
 * This method tells if the quantity of an item is at 0	
 * @return if the quantity returns 0 is true, otherwise it's false 
 */
	public boolean isEmpty() {
		if(numItems() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
/**
 * This method returns the product at an index
 * @param index - of the object on the cart ArrayList
 * @return - the item at the index
 */
public SalableObject getProductAtIndex(int index) {
	return cart.get(index);
}
}
	

