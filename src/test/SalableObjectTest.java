package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.SalableObject;
import app.Weapon;
/**
 * This class tests the methods for all Salable Objects
 * @author Elayne Medina
 *Date: 9/24/22
 */
class SalableObjectTest {

	@Test
	/**
	 * This method tests the Salable Object constructors
	 */
	void testSalableObjectStringStringDoubleInt() {
		SalableObject s = new SalableObject("TestObj", "This is a test object", 40.00, 5);
		assertEquals(s.getName(), "TestObj");
		assertEquals(s.getDiscription(), "This is a test object");
		assertEquals(s.getPrice(), 40.00);
		assertEquals(s.getQuantity(), 5);
		
	}

	@Test
	/**
	 * This method tests the setters and getters for all Salable Objects
	 */
	void testGettersAndSetters() {
		SalableObject s = new SalableObject();
		s.setName("TestObj");
		s.setDiscription("This is a test object");
		s.setPrice(40.00);
		s.setQuantity(5);
		assertEquals(s.getName(), "TestObj");
		assertEquals(s.getDiscription(), "This is a test object");
		assertEquals(s.getPrice(), 40.00);
		assertEquals(s.getQuantity(), 5);
		
	}

	@Test
	/**
	 * This method tests the compare to method for Salable Objects
	 */
	void testCompareTo() {
		SalableObject s1 = new SalableObject("aObject", "This is a test object 1", 40.00, 5);
		SalableObject s2 = new SalableObject("bObject", "This is a test object 2", 40.00, 5);
		SalableObject s3 = new SalableObject("aObject", "This is a test object 1", 40.00, 5);
		assertTrue(s1.compareTo(s2)<0);
		assertTrue(s2.compareTo(s1)> 0);
		assertTrue(s1.compareTo(s3)==0);
	}

	@Test
	/**
	 * This method tests the increment and decrement methods for Salable Objects
	 */
	void testIncrementQuantandDecrementQuant() {
		SalableObject s1 = new SalableObject("aObject", "This is a test object 1", 40.0, 5);
		s1.incrementQuant();
		assertTrue(s1.getQuantity() == 6);
		s1.decrementQuant();
		assertTrue(s1.getQuantity() == 5);
	}
	@Test
	/**
	 * This method tests the toString method for Salable Objects
	 */
	void testToString() {
		SalableObject s1 = new SalableObject("aObject", "This is a test object 1", 40.0, 5);
		String a = "Product name: aObject\nDiscription: This is a test object 1\nPrice: 40.0\nQuantity in stock: 5";
		assertEquals(s1.toString(), a);
	}
	@Test
	/**
	 * This method tests the compare to method in the weapons class it could probably do without but I didn't want to risk affecting the code any further. 
	 */
	void testWeaponCompareTo() {
		Weapon s1 = new Weapon("aWep", "This is a test object 1", 40.00, 5);
		Weapon s2 = new Weapon("bWep", "This is a test object 2", 40.00, 5);
		Weapon s3 = new Weapon("awep", "This is a test object 1", 40.00, 5);
		
		assertTrue(s1.compareTo(s2) < 0);
		assertTrue(s1.compareTo(s3) == 0);
	}

}
