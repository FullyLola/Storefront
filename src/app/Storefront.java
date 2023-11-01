package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This is the main class where the program will run to interact with the user. 
 * My goal is to keep it as organized as possible.
 * @author Elayne Medina
 * @version 4 updated 9/7/22
 * August 21, 2022
 */
public class Storefront {
/**
 * This is the main method, it holds the actions ran in the console. 
 * @param args accepts arguments in the code
 */
	public static void main(String[] args) {
		 Scanner scnr = new Scanner(System.in);
		 InventoryManager inventory = new InventoryManager(InventoryManager.inventoryFromJson("FullInventory.json"));
		 ShoppingCart cart = new ShoppingCart();
		 
		 System.out.println("Welcome to the Storefront!");    //StoreFront Welcome message
		
		 while (true){
			 System.out.println("These are the items in your inventory: ");
			 System.out.println(inventory.toString());         //prints the name of items in the inventory
			 int itemIndex = Utils.askUserInt(scnr, 
                  	"What item would you like to know more about?" +
                   " (Enter the item number or -1 to view cart or -2 to checkout, -3 to see sorting options, -4 to exit)"); //asks user if they want more info
			 if(itemIndex == -2) {  
				 checkout(scnr, inventory, cart);
			 }
			 else if (itemIndex == -1){
				 System.out.println("Here is what's in your cart:");
				 System.out.println(cart.toString());
			 }
			 else if(itemIndex == -3) {
				 userSort(scnr, inventory);
			 }
			 else if(itemIndex == -4) {
				 break;
			 }
			 else if (itemIndex < inventory.numItems() && itemIndex >= 0) {       // Added the >= 0
				 userAddToCart(scnr, cart, itemIndex, inventory);
			 }
			 else {
				 System.out.println("Please enter a valid number.");
			 }
		 }
		 scnr.close();
	}
	
/**
 * This method calls other methods to add the item the user chose to the cart ArrayList
 * @param scnr - yes or no input
 * @param cart - arraylist holding the objects in the user's shopping cart
 * @param itemIndex - when the user designates this value by typing it in the while loop above
 * @param inventory - the object used to call from the Inventory Manager
 */
	 public static void userAddToCart(Scanner scnr, ShoppingCart cart, int itemIndex, InventoryManager inventory) {
		 System.out.println(inventory.getProductAtIndex(itemIndex));                             
		 
		 boolean addToCart = Utils.askUserBool(scnr, "Would you like to add this item to your cart?");
		 if (addToCart) {
			SalableObject item = inventory.getProductAtIndex(itemIndex);
		 	ShoppingCart.moveObject(cart.cart, inventory.products, item);
		 	System.out.println("Item has been added!");
		 }
	 }
	 /**
	  * This method saves an ArrayList of objects to a JSON file
	  * @param fileName - file saving to
	  * @param products - an ArrayList of Salable objects
	  */
		public static void saveArrayListToFile(String fileName, ArrayList<SalableObject> products) {
			clearFile(fileName);
			for(SalableObject item : products) {
				InventoryManager.saveToFile(fileName, item, true);
			}
		}
		/**
		 * This method writes a string message to a JSON file
		 * @param fileName - name of file writing in
		 * @param message - what is being written
		 * @param append - true to add, false not to add
		 */
		public static void writeToFile(String fileName, String message, boolean append) {
			PrintWriter pw = null;
			try {
				File file = new File(fileName);
				FileWriter fw = new FileWriter(file, append);
				pw = new PrintWriter(fw);
				
				pw.print(message);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				pw.close();
			}
		}
		/**
		 * Method clears all info from a JSON file
		 * @param fileName- file being cleared
		 */
		public static void clearFile(String fileName) {
			writeToFile(fileName,"", false);
		}
		
		public static void checkout(Scanner scnr, InventoryManager inventory, ShoppingCart cart) {
			 while(true) {
				 System.out.println("Welcome to Checkout, this is what's in your cart: ");
				 System.out.println(cart.toString());
				 int userInput = Utils.askUserInt(scnr, "Enter the number of the item to remove it or -1 to purchase all or to exit if cart is empty.");
				 if (userInput <= -1) {
					 if(cart.isEmpty()) {
						 System.out.println("Your cart is empty" + "/n" + "This is what is currently in our Inventory:");
						 System.out.println(inventory.toString());
					 }
					 else {
						 cart.removeAll();
						 System.out.println("You have purchased all items");
					}
					 break;
				 }
				 else {
					 ShoppingCart.moveObject(inventory.products, cart.cart, cart.getProductAtIndex(userInput));
				 }
			 }
		}
		
		/**
		 * This method asks the user if they'd like to sort items, how they'd like to sort them and calls the methods that sort
		 * @param scnr - user input
		 * @param inv - inventory manager object
		 */
		public static void userSort(Scanner scnr, InventoryManager inv) {
			int response1 = Utils.askUserInt(scnr, "How would you like to sort the products? \n\tEnter 1 to sort by name \n\tEnter 2 to sort by price");
			boolean sortReverse = Utils.askUserBool(scnr,"Do you want to sort in reverse order?");
			boolean sortOnPrice = response1 == 2;
			
			Comper comper = new Comper(sortOnPrice, !sortReverse);
			inv.sort(comper);
		}
	
}
