package diet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

import diet.Order.PaymentMethod;

/**
 * Represents the main class in the
 * take-away system.
 * 
 * It allows adding restaurant, users, and creating orders.
 *
 */
public class Takeaway {
	
	private Collection<User> users = new ArrayList<User>();
	private Map<String, Restaurant> restaurants = new HashMap<String, Restaurant>();
	
	/**
	 * Adds a new restaurant to the take-away system
	 * 
	 * @param r the restaurant to be added
	 */
	public void addRestaurant(Restaurant r) {
		restaurants.put(r.getName(), r);
	}
	
	/**
	 * Returns the collections of restaurants
	 * 
	 * @return collection of added restaurants
	 */
	public Collection<String> restaurants() {
		return new LinkedList<>(restaurants.keySet());
		// se modifichiamo il treeset modifichiamo la mappa, creando una linkedlist
		// evitiamo modifiche dall'esterno
	}
	
	/**
	 * Define a new user
	 * 
	 * @param firstName first name of the user
	 * @param lastName  last name of the user
	 * @param email     email
	 * @param phoneNumber telephone number
	 * @return
	 */
	public User registerUser(String firstName, String lastName, String email, String phoneNumber) {
		User u = new User(firstName, lastName, email, phoneNumber);
		users.add(u);
		return u;
	}
	
	/**
	 * Gets the collection of registered users
	 * 
	 * @return the collection of users
	 */
	public Collection<User> users(){
		ArrayList<User> u = new ArrayList<User>(users);
		Collections.sort(u);
		return u;
	}
	
	/**
	 * Create a new order by a user to a given restaurant.
	 * 
	 * The order is initially empty and is characterized
	 * by a desired delivery time. 
	 * 
	 * @param user				user object
	 * @param restaurantName	restaurant name
	 * @param h					delivery time hour
	 * @param m					delivery time minutes
	 * @return
	 */
	public Order createOrder(User user, String restaurantName, int h, int m) {
		Restaurant restaurant = restaurants.get(restaurantName);
		
		Order o = new Order(restaurant, user, h, m);
		restaurant.addOrder(o);
		return o;
	}
	
	/**
	 * Retrieves the collection of restaurant that are open
	 * at the given time.
	 * 
	 * @param time time to check open
	 * 
	 * @return collection of restaurants
	 */
	public Collection<Restaurant> openedRestaurants(String time){
		String[] hm = time.split(":");
		Time lt = new Time(Integer.parseInt(hm[0]), Integer.parseInt(hm[1]));

//		SENZA STREAM		
//		ArrayList<Restaurant> opened_r = new ArrayList<Restaurant>();
//		for (Restaurant r : restaurants.values()) {
//			if (r.checkTime(lt)==lt) {
//				opened_r.add(r);
//			}
//		}
//		Collections.sort(opened_r);
//		return opened_r;
		
		// CON STREAM
		return restaurants.values().stream()
		.filter(r -> r.checkTime(lt)==lt)
		.sorted().collect(Collectors.toList());
	}

	
	
}
