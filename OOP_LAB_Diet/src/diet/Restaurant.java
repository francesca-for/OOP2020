package diet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import diet.Order.OrderStatus;

/**
 * Represents a restaurant in the take-away system
 *
 */
public class Restaurant {
	private String name;
	private Food food;
//	private String[] openingH;
//	private String[] closingH;
	private ArrayList<WorkingHours> working_hours;
	private Map<String, Menu> menus = new TreeMap<>();
	private List<Order> orders = new LinkedList<>();
	
	/**
	 * Constructor for a new restaurant.
	 * 
	 * Materials and recipes are taken from
	 * the food object provided as argument.
	 * 
	 * @param name	unique name for the restaurant
	 * @param food	reference food object
	 */
	public Restaurant(String name, Food food) {
		this.name = name;
		this.food = food;
	}
	
	/**
	 * gets the name of the restaurant
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Define opening hours.
	 * 
	 * The opening hours are considered in pairs.
	 * Each pair has the initial time and the final time
	 * of opening intervals.
	 * 
	 * for a restaurant opened from 8:15 until 14:00 and from 19:00 until 00:00, 
	 * is thoud be called as {@code setHours("08:15", "14:00", "19:00", "00:00")}.
	 * 
	 * @param hm a list of opening hours
	 */
//	public void setHours(String ... hm) {
//		int num = hm.length;
//		openingH = new String[num/2];
//		openingH = new String[num/2];
//		int j=0, k=0;
		
//		for(int i=0; i<num; i++) {
//			if(i%2==0) {
//				openingH[j] = hm[i];
//				j++;
//			}
//			else {
//				closingH[k] = hm[i];
//				k++;
//			}
//		}
//	}
	
	/**
	 * Define opening hours.
	 * 
	 * The opening hours are considered in pairs.
	 * Each pair has the initial time and the final time
	 * of opening intervals.
	 * 
	 * for a restaurant opened from 8:15 until 14:00 and from 19:00 until 00:00, 
	 * is thoud be called as {@code setHours("08:15", "14:00", "19:00", "00:00")}.
	 * 
	 * @param hm a list of opening hours
	 */
	public void setHours(String ... hm) {
		working_hours.clear();
		for(int i=0; i<hm.length/2; i++) {
			working_hours.add(new WorkingHours(hm[2*i], hm[2*i+1]));
		}
	}
	
	public Menu getMenu(String name) {
		return menus.get(name);
	}
	
	/**
	 * Creates a new menu
	 * 
	 * @param name name of the menu
	 * 
	 * @return the newly created menu
	 */
	public Menu createMenu(String name) {
		Menu m = food.createMenu(name);
		menus.put(name, m);
		return m;
	}

	/**
	 * Find all orders for this restaurant with 
	 * the given status.
	 * 
	 * The output is a string formatted as:
	 * <pre>
	 * Napoli, Judi Dench : (19:00):
	 * 	M6->1
	 * Napoli, Ralph Fiennes : (19:00):
	 * 	M1->2
	 * 	M6->1
	 * </pre>
	 * 
	 * The orders are sorted by name of restaurant, name of the user, and delivery time.
	 * 
	 * @param status the status of the searched orders
	 * 
	 * @return the description of orders satisfying the criterion
	 */
	public String ordersWithStatus(OrderStatus status) {
		StringBuffer res = new StringBuffer();
		orders.sort(Comparator.comparing( (Order o)->o.getRestaurant().getName()).thenComparing(Order::getUser).thenComparing(Order::getDeliveryTime));
		
		for(Order o : orders)
			if(o.getStatus() == status)
				res.append(o);
		return res.toString();
	}

//	public ArrayList<WorkingHours> getWorking_hours() {
//		return working_hours;
//	}
	
//	public String[] getOpeningH() {
//		return openingH;
//	}
//
//	public String[] getClosingH() {
//		return closingH;
//	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}

	/**
	 * 
	 * @param time
	 * @return time se è incluso in working_hours, il primo orario di apertura altrimenti
	 */
	public Time checkTime(Time time) {
		Collections.sort(working_hours);
		for(WorkingHours w : working_hours) {
			if(w.includes(time))
				return time;
		}
		for(WorkingHours w : working_hours) {
			if(w.getOpen().compareTo(time) > 0)
				return w.getOpen();
		}
		return working_hours.get(0).getOpen();
	}
	
}
