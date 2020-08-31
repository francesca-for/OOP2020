package diet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Represents the main class in the
 * take-away system.
 * 
 * It allows adding restaurant, users, and creating orders.
 *
 */
public class Takeaway {
	
	private Map<String, Restaurant> restaurants = new TreeMap<>();
	
	private Collection<User> users = new TreeSet<User>( (User u1, User u2) -> {
		int compare = u1.getLastName().compareTo(u2.getLastName());
		return (compare==0)? u1.getFirstName().compareTo(u2.getFirstName()) : compare;
		}); 

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
//		return restaurants.keySet();
		//per mantenere la separazione del codice creiamo una LinkedList
		// evito che si possa modificare il keySet e quindi la mappa dall'esterno
		return new LinkedList<>(restaurants.keySet());
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
		User user = new User(firstName, lastName, email, phoneNumber);
		users.add(user);
		return user;
	}
	
	/**
	 * Gets the collection of registered users
	 * 
	 * @return the collection of users
	 */
	public Collection<User> users(){
		return new ArrayList<User>(users);
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
//	public Order createOrder(User user, String restaurantName, int h, int m) {
//		String deliveryT = h + ":" + m;
//		Order order = new Order(user, restaurants.get(restaurantName), deliveryT);
//		return order;
//	}
	
	public Order createOrder(User user, String restaurantName, int h, int m) {
		Order order = new Order(user, restaurants.get(restaurantName), h, m);
		restaurants.get(restaurantName).addOrder(order);
		return order;
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
		Collection<Restaurant> openRest = new ArrayList<>();
		String[] h = time.split(":");
		Time hour = new Time(Integer.parseInt(h[0]), Integer.parseInt(h[1]));
		for(Restaurant r : restaurants.values()) {
			if (hour == r.checkTime(hour))
				openRest.add(r);
		}	
		return openRest;
	}

	
	
}
