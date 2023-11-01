package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * This class manages object inventories
 * @author Elayne Medina
 * @version 5 updated 9/11/22
 * August 21, 2022
 */
public class InventoryManager {
	ArrayList<SalableObject> products;
	
	/**
	 * Constructor that makes sure all inventory arrays are the same initially
	 * @param inventory - ArrayList of SalableObjects
	 */
	public InventoryManager(ArrayList<SalableObject> inventory) {
		products = inventory;
	}
	/**
	 * Constructor ensures that all objects are created when the program initiates
	 */
	public InventoryManager() {
		products = createProducts();
	}
/**
 * This method adds a Salable object of the arraylist products if the item is not found in the array list (quantity reaches 0)
 * if it's found in the arraylist then it will increase the quantity by 1
 * @param p is the salable object used as a parameter to check
 */
	public void addProduct(SalableObject p) {
		boolean found = false;
		for(SalableObject item : products) {
			if(item.getName().equals(p.getName())) {
				found = true;
				item.incrementQuant();
				break;
			}
		}
		if (found == false) {
			products.add(p);
		}
	}
/**
 * This class decrements the quantity of an object when sold
 * will be used more later 
 * @param p is the salable object being checked
 */
	public void removeProduct(SalableObject p) {
		boolean found = false;
		for(SalableObject item : products) {
			if(item.getName().equals(p.getName())) {
				found = true;
				if(item.getQuantity() > 0) {
					item.decrementQuant();
				}
				else {
					System.out.println("Sorry " + item.getName() + " is out of stock, check again later.");
				}
				break;
			}
		}
	}
 /**
  * This class creates all of the salable objects and puts them in an array
  * @return the array of products created
  */
	private static ArrayList<SalableObject> createProducts(){
		ArrayList<SalableObject> products = new ArrayList();
		
		SalableObject weapon1 = new Weapon("Sword", "A thin sword with a long range.", 150.00, 5);   // Changed the constructors for objects 
		SalableObject weapon2 = new Weapon("Brass Knuckles", "Short range weapon", 130.00,5);
		SalableObject health = new Health("Health Potion", "Restores 100 Health Points", 50.00, 5);
		SalableObject armour1 = new Armour("Plate Carrier", "Strong chest protection", 300.00, 5);
		SalableObject armour2 = new Armour("Helmet", "Protects fighter's head", 250.00, 5);
		
		products.add(weapon1);
		products.add(weapon2);
		products.add(health);
		products.add(armour1);
		products.add(armour2);
		
		Collections.sort(products);
		
		Storefront.saveArrayListToFile("FullInventory.json", products);
		
		return products;
	}
/**
 * This Method saves an ArrayList of Salable Objects to a JSON file
 * @param fileName - file saving to
 * @param object - Salable Object
 * @param append - true to add, false not to
 */
	public static void saveToFile(String fileName, SalableObject object, boolean append) {
		PrintWriter pw = null;
		FileWriter fw;
		try {
			File file = new File(fileName);
			fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);
			
			
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(object);
			pw.println(json);
			fw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			pw.close();
		}
	}
	/**
	 * This method turns JSON information into a Salable Objects
	 * @param json - string read from a file
	 * @return null if doesn't work
	 */
	public static SalableObject jsonToObject(String json) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			SalableObject item = objectMapper.readValue(json, SalableObject.class);
			return item;
		}
		catch (IOException e) {
			System.out.println(json);
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
	/**
	 * Creates an ArryaList of Objects from a JSON File
	 * @param fileName - file reading from
	 * @return - ArrayList of Salable objects 
	 */
	public static ArrayList<SalableObject> inventoryFromJson(String fileName){
		ArrayList<SalableObject> items = new ArrayList<SalableObject>();
		try {
			File file = new File(fileName);
			Scanner s = new Scanner(file);
			
			while(s.hasNext()) {
				String json = s.nextLine();
				SalableObject item = jsonToObject(json);
				items.add(item);
			}
			return items;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}

	/**
	 * This method returns a string of inventory objects in the correct format
	 */
	public String toString() {
		 String ans = "";
		  for(int i = 0; i < products.size(); i++){
			  ans += i + ": " + products.get(i).getName() + "\n\tPrice: " + products.get(i).getPrice() + "\n\tQuantity in inventory: " + products.get(i).getQuantity() + " \n";
		  }
		  return ans;
	}
/**
 * This method returns a specific salable object at the 
 * index in the parameter	
 * @param index of the salable object
 * @return the salable object at the index in the parameter
 */
	public SalableObject getProductAtIndex(int index) {                
		return products.get(index);
	}
/**
 * This returns the quantity of salable objects in the array
 * @return size of the array named products/ num of objects in the array
 */
	public int numItems() {
		return products.size();
	}
	/**
	 * This method sorts the ArrayList of salable objects based on Name or Price in ascending or descending order
	 * @param comper - comper object that compares salable objects
	 */
	public void sort(Comparator<SalableObject> comper) {
		Collections.sort(products, comper);
	}
	
}
