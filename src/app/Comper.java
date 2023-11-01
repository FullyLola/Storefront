package app;

import java.util.Comparator;

/**
 * This class was created to help compare and sort objects
 * @author Elayne Medina
 * September 11, 2022 
 */
public class Comper implements Comparator<SalableObject> {

	private boolean sortOnPrice;
	private boolean ascend;
	
	/**
	 * This constructor creates Coper objects
	 * @param sortOnPrice - tells if sorting will be based on name or price
	 * @param ascend - ascending or descending order
	 */
	public Comper(boolean sortOnPrice, boolean ascend) {
		this.sortOnPrice = sortOnPrice;
		this.ascend = ascend;
	}
	
	@Override
	/**
	 * This method compares two objects based on name or price in ascending or descending order
	 */
	public int compare(SalableObject o1, SalableObject o2) {
		int result = 0;
		if(sortOnPrice) {
			if (o1.getPrice() > o2.getPrice()) {
				result = 1;
			}
			else if (o1.getPrice() < o2.getPrice()) {
				result = -1;
			}
			else {
				result = 0;
			}
		}
		else {
			String w = o1.getName().toLowerCase();     
			String o = o2.getName().toLowerCase();    
			
			result = w.compareTo(o); 
		}
		if (ascend) {
			return result;
		}
		else {
			return -result;
		}
	}

	
}
