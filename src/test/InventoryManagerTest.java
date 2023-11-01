package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import app.Comper;
import app.InventoryManager;
import app.SalableObject;
/**
 * This class tests the methods of the Inventory Manager Class
 * @author Elayne Medina
 * Date: 9/24/22
 */
public class InventoryManagerTest {

	@Test
	/**
	 * This method tests the addProduct and sort methods 
	 */
	public void testAddProductAndSort() {
		ArrayList<SalableObject> objs = new ArrayList();
		objs.add(new SalableObject("Sword", "This is a test object 1", 40.00, 3));
		InventoryManager inv = new InventoryManager(objs);
		SalableObject s1 = new SalableObject("Sword", "This is a test object 1", 40.00, 3);
		SalableObject s2 = new SalableObject("aObject", "This is a test object 1", 30.00, 3);
		
		int a = inv.getProductAtIndex(0).getQuantity();
		inv.addProduct(s1);
		assertEquals(inv.getProductAtIndex(0).getQuantity(), a+1);
		
		inv.addProduct(s2);
		assertEquals(inv.getProductAtIndex(1).getQuantity(), 3);
		
		assertEquals(inv.numItems(), 2);
		assertEquals(inv.getProductAtIndex(0).getName(), "Sword");
		inv.sort(new Comper(false,true));
		assertEquals(inv.getProductAtIndex(0).getName(), "aObject");
		inv.sort(new Comper(true,false));
		assertEquals(inv.getProductAtIndex(0).getName(), "Sword");
	}

	@Test
	/**
	 * This method tests the removeProducts method
	 */
	public void testRemoveProduct() {
		InventoryManager inv = new InventoryManager();
		
		SalableObject s1 = new SalableObject("Brass Knuckles", "Short range weapon", 130.00,5);
		SalableObject s2 = new SalableObject("aObject", "This is a test object 1", 40.00, 0);
		
		int a = inv.getProductAtIndex(0).getQuantity();
		inv.removeProduct(s1);
		assertEquals(inv.getProductAtIndex(0).getQuantity(), a-1);
		inv.removeProduct(s2);
		inv.removeProduct(s1);
		inv.removeProduct(s1);
		inv.removeProduct(s1);
		inv.removeProduct(s1);
		assertEquals(inv.getProductAtIndex(0).getQuantity(), 0);
		inv.removeProduct(s1);
		assertEquals(inv.getProductAtIndex(0).getQuantity(), 0);		
		
	}
	
	@Test
	/**
	 * This method tests the jsonToObject Method
	 */
	public void testJsonToObject() {
		InventoryManager inv = new InventoryManager();
		SalableObject a = inv.jsonToObject("{\"name\":\"Brass Knuckles\",\"discription\":\"Short range weapon\",\"price\":130.0,\"quantity\":5}");
		assertEquals(a.getName(), "Brass Knuckles");
	}

	@Test
	/**
	 * This method tests the inventory from json method
	 */
	public void testInventoryFromJson() {
		InventoryManager inv = new InventoryManager();
		inv.inventoryFromJson("FullInventory.json");
		assertEquals(inv.getProductAtIndex(0).getName(), "Brass Knuckles");
		
	}

	@Test
	/**
	 * This method tests the toString method in the InventoryManger class
	 */
	public void testToString() {
		InventoryManager inv = new InventoryManager();
		String s = "0: Brass Knuckles\n\tPrice: 130.0\n\tQuantity "
				+ "in inventory: 5 \n1: Health Potion\n\tPrice: 50.0\n\tQuantity in "
				+ "inventory: 5 \n2: Helmet\n\tPrice: 250.0\n\tQuantity in inventory:"
				+ " 5 \n3: Plate Carrier\n\tPrice: 300.0\n\tQuantity in inventory: 5 \n4: "
				+ "Sword\n\tPrice: 150.0\n\tQuantity in inventory: 5 \n";
		assertEquals(s, inv.toString());
	}


}
